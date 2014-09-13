package com.pmarlen.rest;

import com.pmarlen.model.beans.AlmacenProducto;
import com.pmarlen.model.beans.Perfil;
import com.pmarlen.model.beans.Producto;
import com.pmarlen.model.controller.ProductoJPAController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("almacenProductoService")
@RequestMapping("/almacenProducto")
public class AlmacenProductoService {
	private Logger logger;

	public AlmacenProductoService() {
		logger = LoggerFactory.getLogger(AlmacenProductoService.class);
		logger.debug("->AlmacenProductoService, created");
	}
	
	@Autowired
	private ProductoJPAController productoJPAController;	

	public void setAlmacenProductoJPAController(ProductoJPAController almacenProductoJPAController){
		this.productoJPAController = productoJPAController;
	}
	
	@RequestMapping(value = "getAllOfAlmacen", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.AlmacenProducto> getAllOfAlmacen(
			@RequestParam(value = "almacenId",required = false,defaultValue = "1") Integer almacenId) {	
		logger.info("->getAllOfAlmacen invoked: almacenId="+almacenId);
		List<com.pmarlen.wscommons.services.dto.AlmacenProducto> result=new ArrayList<com.pmarlen.wscommons.services.dto.AlmacenProducto>();		
		
		final List<AlmacenProducto> jpaList = productoJPAController.findAllValidProductosForAlmacen(almacenId);
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.AlmacenProducto dto = null;
		for(AlmacenProducto l: jpaList){
			Producto p = l.getProducto();
			dto = new com.pmarlen.wscommons.services.dto.AlmacenProducto(l);			
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}