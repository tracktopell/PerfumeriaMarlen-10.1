package com.pmarlen.model.controller;

import org.springframework.stereotype.Repository;

import com.pmarlen.model.beans.Almacen;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AlmacenJPAController
 */

@Repository("almacenJPAController")
public class AlmacenJPAController extends EntityJPAController<Almacen>{

	public AlmacenJPAController() {
		super(LoggerFactory.getLogger(AlmacenJPAController.class));
	}

	@Override
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Almacen newEntityInstance() {
		return new Almacen();
	}

	@Override
	protected Class getEntityClass() {
		return Almacen.class;
	}

	@Override
	protected String getEntityClassName() {
		return "Almacen";
	}

	@Override
	protected boolean isAffectedBySincronizacionEvent() {
		return true;
	}

	@Override
	protected Object getEntityId(Almacen entity) {
		return entity.getId();
	}

	/*@Override
	protected void retrieveLazyAtributes(Almacen x) {
		x.getPoblacion();
		x.getPedidoVentaCollection();
		x.getNotaCreditoCollection();
	}*/

	@Override
	public Almacen findEntityByReadableProperty(String id) {
		logger.debug("->@Override findById:id="+id);
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select x from Almacen x where x.id = id");

			q.setParameter("id", new Integer(id));
			Almacen x = (Almacen) q.getSingleResult();
			
			if (x != null) {
				retrieveEagerAllAtributes(x);
			}
			return x;
		} finally {
			em.close();
		}
	}

	@Override
	protected void validateBeforeDestroy(EntityManager em, Object almacenId, List<String> illegalOrphanMessages) {
		Query q = null;
		int countRelated = -1;
		
		String relatedEntities[] = {
				"AlmacenProducto",
				"EntradaAlmacen",
				"MovimientoOperativoAlmacen",
				"PedidoVentaDetalle"};
		for(String re:relatedEntities){
			q = em.createQuery("select count(x) from "+re+" x where x.almacen.id= :almacenId");
			q.setParameter("almacenId", almacenId);
			countRelated = ((Long) q.getSingleResult()).intValue();

			if (countRelated > 0) {
				final String name = "Hay " + countRelated + " "+re+"(s), relacionados a este Almacen";
				illegalOrphanMessages.add(name.toUpperCase());
			}
		}
	}

	protected String orderBy(String object){
		return " order by "+object+".id";
	}
}
