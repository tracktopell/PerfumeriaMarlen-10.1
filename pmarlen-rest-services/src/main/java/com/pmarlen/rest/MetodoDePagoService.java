package com.pmarlen.rest;

import com.pmarlen.model.beans.MetodoDePago;
import com.pmarlen.model.controller.MetodoDePagoJPAController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("metodoDePagoService")
@RequestMapping("/metodoDePago")
public class MetodoDePagoService {
	private Logger logger;

	public MetodoDePagoService() {
		logger = LoggerFactory.getLogger(MetodoDePagoService.class);
		logger.debug("->MetodoDePagoService, created");
	}
	
	@Autowired
	private MetodoDePagoJPAController metodoDePagoJPAController;	

	public void setMetodoDePagoJPAController(MetodoDePagoJPAController metodoDePagoJPAController){
		this.metodoDePagoJPAController=metodoDePagoJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.MetodoDePago> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.MetodoDePago> result=new ArrayList<com.pmarlen.wscommons.services.dto.MetodoDePago>();		

		final List<MetodoDePago> jpaList = metodoDePagoJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.MetodoDePago dto = null;
		for(MetodoDePago l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.MetodoDePago(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}