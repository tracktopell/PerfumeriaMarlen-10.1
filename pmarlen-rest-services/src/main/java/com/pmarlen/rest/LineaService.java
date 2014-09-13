package com.pmarlen.rest;

import com.pmarlen.model.beans.Linea;
import com.pmarlen.model.controller.LineaJPAController;
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

@Controller("lineaService")
@RequestMapping("/linea")
public class LineaService {
	private Logger logger;

	public LineaService() {
		logger = LoggerFactory.getLogger(LineaService.class);
		logger.debug("->LineaService, created");
	}

	@Autowired
	private LineaJPAController lineaJPAController;	

	public void setLineaJPAController(LineaJPAController lineaJPAController){
		this.lineaJPAController=lineaJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Linea> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Linea> resultLinea=new ArrayList<com.pmarlen.wscommons.services.dto.Linea>();		

		final List<Linea> jpaLineaList = lineaJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaLineaList==null));

		com.pmarlen.wscommons.services.dto.Linea dtoLinea = null;
		for(Linea xi: jpaLineaList){
			dtoLinea = new com.pmarlen.wscommons.services.dto.Linea(xi);			
			resultLinea.add(dtoLinea);
			logger.debug("->getAll \tadd dto:"+dtoLinea);
		}
		
		return resultLinea;
	}

	@RequestMapping(value = "/put",method = RequestMethod.POST,
	consumes = "application/json",produces = "application/json")
	public @ResponseBody com.pmarlen.wscommons.services.dto.Linea put(@RequestBody com.pmarlen.wscommons.services.dto.Linea requestBody){
		logger.debug("->put requestBody="+requestBody);
		
		com.pmarlen.wscommons.services.dto.Linea l=new com.pmarlen.wscommons.services.dto.Linea();
		
		l.setId(requestBody.getId()+1);
		l.setNombre(requestBody.getNombre()+"X");

		return l;
	}

}
