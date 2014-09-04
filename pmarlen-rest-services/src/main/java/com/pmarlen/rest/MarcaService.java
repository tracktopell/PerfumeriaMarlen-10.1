package com.pmarlen.rest;

import com.pmarlen.model.beans.Marca;
import com.pmarlen.model.controller.MarcaJPAController;
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

@Controller("marcaService")
@RequestMapping("/marca")
public class MarcaService {
	private Logger logger;

	public MarcaService() {
		logger = LoggerFactory.getLogger(MarcaService.class);
		logger.debug("->MarcaService, created");
	}
	
	@Autowired
	private MarcaJPAController marcaJPAController;	

	public void setMarcaJPAController(MarcaJPAController marcaJPAController){
		this.marcaJPAController=marcaJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Marca> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Marca> result=new ArrayList<com.pmarlen.wscommons.services.dto.Marca>();		

		final List<Marca> jpaList = marcaJPAController.findAllEntities();
		logger.debug("->getAll jpaList="+jpaList);

		com.pmarlen.wscommons.services.dto.Marca dto = null;
		for(Marca l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Marca(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}

}
