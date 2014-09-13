package com.pmarlen.rest;

import com.pmarlen.model.beans.Sucursal;
import com.pmarlen.model.controller.SucursalJPAController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("sucursalService")
@RequestMapping("/sucursal")
public class SucursalService {
	private Logger logger;

	public SucursalService() {
		logger = LoggerFactory.getLogger(SucursalService.class);
		logger.debug("->SucursalService, created");
	}
	
	@Autowired
	private SucursalJPAController sucursalJPAController;	

	public void setSucursalJPAController(SucursalJPAController sucursalJPAController){
		this.sucursalJPAController=sucursalJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Sucursal> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Sucursal> result=new ArrayList<com.pmarlen.wscommons.services.dto.Sucursal>();		

		final List<Sucursal> jpaList = sucursalJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.Sucursal dto = null;
		for(Sucursal l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Sucursal(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}