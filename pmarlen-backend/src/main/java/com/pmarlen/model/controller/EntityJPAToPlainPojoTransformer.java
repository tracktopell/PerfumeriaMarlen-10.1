/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmarlen.model.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Entity;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alfredo
 */
public class EntityJPAToPlainPojoTransformer {

	private static Logger logger = LoggerFactory.getLogger(EntityJPAToPlainPojoTransformer.class);

	public static void copyPlainValues(Entity entity, Object plain) {
		final Class entityClass;
		entityClass = entity.getClass();
		final String entityClassName = entityClass.getName();
		Hashtable<String, Object> propertiesToCopy = new Hashtable<String, Object>();
		Hashtable<String, Object> propertiesM2MToCopy = new Hashtable<String, Object>();
		List<String> propertiesWithNULLValueToCopy = new ArrayList<String>();
		List<String> propertiesKey = new ArrayList<String>();
		try {
			final Field[] declaredFields = entityClass.getDeclaredFields();
			for (Field f : declaredFields) {
				logger.trace("->create: \tcopy: " + entityClassName + "." + f.getName() + " accesible ? " + (f.isAccessible()));
				if (!f.isAccessible()) {

					if (f.isAnnotationPresent(javax.persistence.Id.class)) {
						propertiesKey.add(f.getName());
					}
					if (f.isAnnotationPresent(javax.persistence.Id.class)
							&& !f.isAnnotationPresent(javax.persistence.GeneratedValue.class)
							&& !Modifier.isStatic(f.getModifiers())) {

						Object valueCopyed = PropertyUtils.getProperty(entity, f.getName());
						if (valueCopyed != null) {
							propertiesToCopy.put(f.getName(), valueCopyed);
						} else {
							propertiesWithNULLValueToCopy.add(f.getName());
						}
						logger.trace("->create:\t\t ID elegible 2 be copied, added to copy list: " + f.getName() + " = " + valueCopyed + ", is really null?" + (valueCopyed == null));
					} else if (!f.isAnnotationPresent(javax.persistence.Id.class)
							&& !f.isAnnotationPresent(javax.persistence.OneToMany.class)
							&& !f.isAnnotationPresent(javax.persistence.ManyToMany.class)
							&& !Modifier.isStatic(f.getModifiers())) {

						Object valueCopyed = PropertyUtils.getProperty(entity, f.getName());
						if (valueCopyed != null) {
							propertiesToCopy.put(f.getName(), valueCopyed);
						} else {
							propertiesWithNULLValueToCopy.add(f.getName());
						}
						logger.trace("->create:\t\t elegible 2 be copied, added to copy list: " + f.getName() + " = " + valueCopyed + ", is really null?" + (valueCopyed == null));
					} else if (!f.isAnnotationPresent(javax.persistence.Id.class)
							&& f.isAnnotationPresent(javax.persistence.ManyToMany.class)) {

						Object valueCopyed = PropertyUtils.getProperty(entity, f.getName());
						if (valueCopyed != null) {
							propertiesM2MToCopy.put(f.getName(), valueCopyed);
						} else {
							propertiesWithNULLValueToCopy.add(f.getName());
						}
						logger.trace("->create:\t\t M2M elegible 2 be copied, added to copy list: " + f.getName() + " = " + valueCopyed + ", is really null?" + (valueCopyed == null));
					}
				}
			}
			logger.trace("->create:copy values ?");
			for (String p2c : propertiesToCopy.keySet()) {
				Object valueCopyed = propertiesToCopy.get(p2c);
				logger.trace("->create:\t\t copy value with SpringUtils: " + p2c + " = " + valueCopyed + ", is null?" + (valueCopyed == null));
				BeanUtils.copyProperty(plain, p2c, valueCopyed);
			}
			for (String p2c : propertiesWithNULLValueToCopy) {
				logger.trace("->create:\t\t copy null with SpringUtils");
				BeanUtils.copyProperty(plain, p2c, null);
			}
		}catch(Exception e){
			logger.error("..in copy", e);
		}
	}
}
