package com.pmarlen.rest;

import com.pmarlen.model.beans.Cliente;
import com.pmarlen.model.controller.ClienteJPAController;
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

@Controller("clienteService")
@RequestMapping("/cliente")
public class ClienteService {
	private Logger logger;

	public ClienteService() {
		logger = LoggerFactory.getLogger(ClienteService.class);
		logger.debug("->ClienteService, created");
	}
	
	@Autowired
	private ClienteJPAController clienteJPAController;	

	public void setClienteJPAController(ClienteJPAController clienteJPAController){
		this.clienteJPAController=clienteJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Cliente> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Cliente> result=new ArrayList<com.pmarlen.wscommons.services.dto.Cliente>();		

		final List<Cliente> jpaList = clienteJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.Cliente dto = null;
		for(Cliente l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Cliente(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}