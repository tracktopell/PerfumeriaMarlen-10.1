package com.pmarlen.rest;

import com.pmarlen.model.beans.Industria;
import com.pmarlen.model.controller.IndustriaJPAController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("industriaService")
@RequestMapping("/industria")
public class IndustriaService {
	private Logger logger;

	public IndustriaService() {
		logger = LoggerFactory.getLogger(IndustriaService.class);
		logger.debug("->IndustriaService, created");
	}
	
	@Autowired
	private IndustriaJPAController industriaJPAController;	

	public void setIndustriaJPAController(IndustriaJPAController industriaJPAController){
		this.industriaJPAController=industriaJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Industria> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Industria> result=new ArrayList<com.pmarlen.wscommons.services.dto.Industria>();		

		final List<Industria> jpaList = industriaJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.Industria dto = null;
		for(Industria l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Industria(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}

}
