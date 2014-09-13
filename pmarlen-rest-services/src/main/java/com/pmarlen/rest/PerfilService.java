package com.pmarlen.rest;

import com.pmarlen.model.beans.Perfil;
import com.pmarlen.model.controller.PerfilJPAController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("perfilService")
@RequestMapping("/perfil")
public class PerfilService {
	private Logger logger;

	public PerfilService() {
		logger = LoggerFactory.getLogger(PerfilService.class);
		logger.debug("->PerfilService, created");
	}
	
	@Autowired
	private PerfilJPAController perfilJPAController;	

	public void setPerfilJPAController(PerfilJPAController perfilJPAController){
		this.perfilJPAController=perfilJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Perfil> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Perfil> result=new ArrayList<com.pmarlen.wscommons.services.dto.Perfil>();		

		final List<Perfil> jpaList = perfilJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.Perfil dto = null;
		for(Perfil l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Perfil(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}