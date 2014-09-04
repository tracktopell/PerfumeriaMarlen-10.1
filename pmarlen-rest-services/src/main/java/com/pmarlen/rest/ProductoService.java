package com.pmarlen.rest;

import com.pmarlen.model.beans.Producto;
import com.pmarlen.model.controller.ProductoJPAController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("productoService")
@RequestMapping("/producto")
public class ProductoService {
	private Logger logger;

	public ProductoService() {
		logger = LoggerFactory.getLogger(ProductoService.class);
		logger.debug("->ProductoService, created");
	}
	
	@Autowired
	private ProductoJPAController productoJPAController;	

	public void setProductoJPAController(ProductoJPAController productoJPAController){
		this.productoJPAController=productoJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Producto> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Producto> result=new ArrayList<com.pmarlen.wscommons.services.dto.Producto>();		

		final List<Producto> jpaList = productoJPAController.findAllEntities();
		logger.debug("->getAll jpaList="+jpaList);

		com.pmarlen.wscommons.services.dto.Producto dto = null;
		for(Producto l: jpaList){
			dto = new com.pmarlen.wscommons.services.dto.Producto(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}

	@RequestMapping(value = "get/{productoId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody com.pmarlen.wscommons.services.dto.Producto get(@PathVariable String productoId) {	
		List<com.pmarlen.wscommons.services.dto.Producto> result=new ArrayList<com.pmarlen.wscommons.services.dto.Producto>();		
		com.pmarlen.wscommons.services.dto.Producto dto = null;
		logger.debug("->get from productoJPAController.findLazyById("+productoId+")");
		Producto entityJPA = productoJPAController.findLazyById(new Integer(productoId));
		if(entityJPA != null){
			dto = new com.pmarlen.wscommons.services.dto.Producto(entityJPA);			
		}
		return dto;
	}
}
