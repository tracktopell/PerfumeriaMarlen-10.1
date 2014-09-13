/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmarlen.rest;

import com.pmarlen.model.controller.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pmarlen.wscommons.services.dto.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alfredo
 */
@Controller("SicnonizacionSucursalService")
@RequestMapping("/sicnonizacionSucursal")
public class SicnonizacionSucursalService {
	private Logger logger;

	public SicnonizacionSucursalService() {
		logger = LoggerFactory.getLogger(SicnonizacionSucursalService.class);
		logger.debug("->SicnonizacionSucursalService, created");
	}
	
	@Autowired private LineaJPAController lineaJPAController;
	public void setLineaJPAController(LineaJPAController lineaJPAController) {
		this.lineaJPAController = lineaJPAController;
	}
	
	@Autowired private IndustriaJPAController industriaJPAController;

	public void setIndustriaJPAController(IndustriaJPAController industriaJPAController) {
		this.industriaJPAController = industriaJPAController;
	}
	
	@Autowired private MarcaJPAController marcaJPAController;	

	public void setMarcaJPAController(MarcaJPAController marcaJPAController) {
		this.marcaJPAController = marcaJPAController;
	}
	
	@Autowired private ProductoJPAController productoJPAController;	
	public void setProductoJPAController(ProductoJPAController productoJPAController){
		this.productoJPAController=productoJPAController;
	}

	@Autowired private AlmacenJPAController almacenJPAController;

	public void setAlmacenJPAController(AlmacenJPAController almacenJPAController) {
		this.almacenJPAController = almacenJPAController;
	}
	
	@Autowired private SucursalJPAController sucursalJPAController;	

	public void setSucursalJPAController(SucursalJPAController sucursalJPAController) {
		this.sucursalJPAController = sucursalJPAController;
	}
	
	@Autowired private ClienteJPAController clienteJPAController;

	public void setClienteJPAController(ClienteJPAController clienteJPAController) {
		this.clienteJPAController = clienteJPAController;
	}
	
	@Autowired private MetodoDePagoJPAController metodoDePagoJPAController;

	public void setMetodoDePagoJPAController(MetodoDePagoJPAController metodoDePagoJPAController) {
		this.metodoDePagoJPAController = metodoDePagoJPAController;
	}
	
	@Autowired private FormaDePagoJPAController formaDePagoJPAController;

	public void setFormaDePagoJPAController(FormaDePagoJPAController formaDePagoJPAController) {
		this.formaDePagoJPAController = formaDePagoJPAController;
	}
	
	@Autowired private PerfilJPAController perfilJPAController;

	public void setPerfilJPAController(PerfilJPAController perfilJPAController) {
		this.perfilJPAController = perfilJPAController;
	}
	
	@Autowired private UsuarioJPAController usuarioJPAController;	

	public void setUsuarioJPAController(UsuarioJPAController usuarioJPAController) {
		this.usuarioJPAController = usuarioJPAController;
	}

	@RequestMapping(value = "getAllOfSucursal", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody PaqueteDeSincronizacionSucursalHija getAllOfSucursal(@RequestParam(value = "sucursalId",required = false,defaultValue = "1") Integer sucursalId) {	
		logger.info("->getAllOfAlmacen invoked: sucursalId="+sucursalId);
		
		PaqueteDeSincronizacionSucursalHija result = new PaqueteDeSincronizacionSucursalHija(sucursalId);
		result.setTipoTransaccion(1);
		//============================= Linea ==================================
		List<com.pmarlen.wscommons.services.dto.Linea> resultLineaList=new ArrayList<com.pmarlen.wscommons.services.dto.Linea>();
		final List<com.pmarlen.model.beans.Linea> jpaLineaList = lineaJPAController.findAllEntities();
		logger.debug("->getAllOfAlmacen jpaLineaList is null ?"+(jpaLineaList==null));
		com.pmarlen.wscommons.services.dto.Linea dtoLinea = null;
		for(com.pmarlen.model.beans.Linea xi: jpaLineaList){
			dtoLinea = new com.pmarlen.wscommons.services.dto.Linea(xi);			
			resultLineaList.add(dtoLinea);
			logger.debug("->jpaLineaList \tadd dto:"+dtoLinea);
		}
		result.setLineaList(resultLineaList);
		//============================= Industria ==================================
		List<com.pmarlen.wscommons.services.dto.Industria> resultIndustriaList=new ArrayList<com.pmarlen.wscommons.services.dto.Industria>();
		final List<com.pmarlen.model.beans.Industria> jpaIndustriaList = industriaJPAController.findAllEntities();
		logger.debug("->getAllOfAlmacen jpaIndustriaList is null ?"+(jpaIndustriaList==null));
		com.pmarlen.wscommons.services.dto.Industria dtoIndustria = null;
		for(com.pmarlen.model.beans.Industria xi: jpaIndustriaList){
			dtoIndustria = new com.pmarlen.wscommons.services.dto.Industria(xi);			
			resultIndustriaList.add(dtoIndustria);
			logger.debug("->jpaIndustriaList \tadd dto:"+dtoIndustria);
		}
		result.setIndustriaList(resultIndustriaList);
		//============================= Marca ==================================
		List<com.pmarlen.wscommons.services.dto.Marca> resultMarcaList=new ArrayList<com.pmarlen.wscommons.services.dto.Marca>();
		final List<com.pmarlen.model.beans.Marca> jpaMarcaList = marcaJPAController.findAllEntities();
		logger.debug("->getAllOfAlmacen jpaMarcaList is null ?"+(jpaMarcaList==null));
		com.pmarlen.wscommons.services.dto.Marca dtoMarca = null;
		for(com.pmarlen.model.beans.Marca xi: jpaMarcaList){
			dtoMarca = new com.pmarlen.wscommons.services.dto.Marca(xi);			
			resultMarcaList.add(dtoMarca);
			logger.debug("->jpaMarcaList \tadd dto:"+dtoMarca);
		}
		result.setMarcaList(resultMarcaList);
		//============================= Producto ==================================
		List<com.pmarlen.wscommons.services.dto.Producto> resultProductoList=new ArrayList<com.pmarlen.wscommons.services.dto.Producto>();
		final List<com.pmarlen.model.beans.Producto> jpaProductoList = productoJPAController.findAllEntities();
		logger.debug("->getAllOfAlmacen jpaProductoList is null ?"+(jpaProductoList==null));
		com.pmarlen.wscommons.services.dto.Producto dtoProducto = null;
		for(com.pmarlen.model.beans.Producto xi: jpaProductoList){
			dtoProducto = new com.pmarlen.wscommons.services.dto.Producto(xi);			
			resultProductoList.add(dtoProducto);
			logger.debug("->jpaProductoList \tadd dto:"+dtoProducto);
		}
		result.setProductoList(resultProductoList);
		//============================= Almacen ==================================
		List<com.pmarlen.wscommons.services.dto.Almacen> resultAlmacenList=new ArrayList<com.pmarlen.wscommons.services.dto.Almacen>();
		final List<com.pmarlen.model.beans.Almacen> jpaAlmacenList = almacenJPAController.findAllEntities();
		logger.debug("->getAllOfAlmacen jpaAlmacenList is null ?"+(jpaAlmacenList==null));
		com.pmarlen.wscommons.services.dto.Almacen dtoAlmacen = null;
		for(com.pmarlen.model.beans.Almacen xi: jpaAlmacenList){
			dtoAlmacen = new com.pmarlen.wscommons.services.dto.Almacen(xi);			
			resultAlmacenList.add(dtoAlmacen);
			logger.debug("->jpaAlmacenList \tadd dto:"+dtoAlmacen);
		}
		result.setAlmacenList(resultAlmacenList);
		//============================= Sucursal ==================================
		List<com.pmarlen.wscommons.services.dto.Sucursal> resultSucursalList=new ArrayList<com.pmarlen.wscommons.services.dto.Sucursal>();
		final List<com.pmarlen.model.beans.Sucursal> jpaSucursalList = sucursalJPAController.findAllEntities();
		logger.debug("->getAllOfSucursal jpaSucursalList is null ?"+(jpaSucursalList==null));
		com.pmarlen.wscommons.services.dto.Sucursal dtoSucursal = null;
		for(com.pmarlen.model.beans.Sucursal xi: jpaSucursalList){
			dtoSucursal = new com.pmarlen.wscommons.services.dto.Sucursal(xi);			
			resultSucursalList.add(dtoSucursal);
			logger.debug("->jpaSucursalList \tadd dto:"+dtoSucursal);
		}
		result.setSucursalList(resultSucursalList);
		//========================= AlmacenProducto ============================
		List<com.pmarlen.wscommons.services.dto.AlmacenProducto> resultAlmacenProductoList = new ArrayList<com.pmarlen.wscommons.services.dto.AlmacenProducto>();		
		
		final List<com.pmarlen.model.beans.AlmacenProducto> jpaList = productoJPAController.findAllValidProductosForSucursal(sucursalId);
		logger.debug("->getAllOfAlmacen jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.AlmacenProducto dto = null;
		for(com.pmarlen.model.beans.AlmacenProducto xi: jpaList){
			com.pmarlen.model.beans.Producto p = xi.getProducto();
			dto = new com.pmarlen.wscommons.services.dto.AlmacenProducto(xi);			
			resultAlmacenProductoList.add(dto);
			logger.debug("->getAllOfAlmacen \tadd dto:"+dto);
		}
		result.setAlmacenProductoList(resultAlmacenProductoList);
		//============================= Cliente ==================================
		List<com.pmarlen.wscommons.services.dto.Cliente> resultClienteList=new ArrayList<com.pmarlen.wscommons.services.dto.Cliente>();
		final List<com.pmarlen.model.beans.Cliente> jpaClienteList = clienteJPAController.findAllEntities();
		logger.debug("->getAllOfCliente jpaClienteList is null ?"+(jpaClienteList==null));
		com.pmarlen.wscommons.services.dto.Cliente dtoCliente = null;
		for(com.pmarlen.model.beans.Cliente xi: jpaClienteList){
			dtoCliente = new com.pmarlen.wscommons.services.dto.Cliente(xi);			
			resultClienteList.add(dtoCliente);
			logger.debug("->jpaClienteList \tadd dto:"+dtoCliente);
		}
		result.setClienteList(resultClienteList);
		//============================= MetodoDePago ==================================
		List<com.pmarlen.wscommons.services.dto.MetodoDePago> resultMetodoDePagoList=new ArrayList<com.pmarlen.wscommons.services.dto.MetodoDePago>();
		final List<com.pmarlen.model.beans.MetodoDePago> jpaMetodoDePagoList = metodoDePagoJPAController.findAllEntities();
		logger.debug("->getAllOfMetodoDePago jpaMetodoDePagoList is null ?"+(jpaMetodoDePagoList==null));
		com.pmarlen.wscommons.services.dto.MetodoDePago dtoMetodoDePago = null;
		for(com.pmarlen.model.beans.MetodoDePago xi: jpaMetodoDePagoList){
			dtoMetodoDePago = new com.pmarlen.wscommons.services.dto.MetodoDePago(xi);			
			resultMetodoDePagoList.add(dtoMetodoDePago);
			logger.debug("->jpaMetodoDePagoList \tadd dto:"+dtoMetodoDePago);
		}
		result.setMetodoDePagoList(resultMetodoDePagoList);
		//============================= FormaDePago ==================================
		List<com.pmarlen.wscommons.services.dto.FormaDePago> resultFormaDePagoList=new ArrayList<com.pmarlen.wscommons.services.dto.FormaDePago>();
		final List<com.pmarlen.model.beans.FormaDePago> jpaFormaDePagoList = formaDePagoJPAController.findAllEntities();
		logger.debug("->getAllOfFormaDePago jpaFormaDePagoList is null ?"+(jpaFormaDePagoList==null));
		com.pmarlen.wscommons.services.dto.FormaDePago dtoFormaDePago = null;
		for(com.pmarlen.model.beans.FormaDePago xi: jpaFormaDePagoList){
			dtoFormaDePago = new com.pmarlen.wscommons.services.dto.FormaDePago(xi);			
			resultFormaDePagoList.add(dtoFormaDePago);
			logger.debug("->jpaFormaDePagoList \tadd dto:"+dtoFormaDePago);
		}
		result.setFormaDePagoList(resultFormaDePagoList);
		//============================= Perfil ==================================
		List<com.pmarlen.wscommons.services.dto.Perfil> resultPerfilList=new ArrayList<com.pmarlen.wscommons.services.dto.Perfil>();
		final List<com.pmarlen.model.beans.Perfil> jpaPerfilList = perfilJPAController.findAllEntities();
		logger.debug("->getAllOfPerfil jpaPerfilList is null ?"+(jpaPerfilList==null));
		com.pmarlen.wscommons.services.dto.Perfil dtoPerfil = null;
		for(com.pmarlen.model.beans.Perfil xi: jpaPerfilList){
			dtoPerfil = new com.pmarlen.wscommons.services.dto.Perfil(xi);			
			resultPerfilList.add(dtoPerfil);
			logger.debug("->jpaPerfilList \tadd dto:"+dtoPerfil);
		}
		result.setPerfilList(resultPerfilList);
		//============================= Usuario ==================================
		List<com.pmarlen.wscommons.services.dto.Usuario> resultUsuarioList=new ArrayList<com.pmarlen.wscommons.services.dto.Usuario>();
		final List<com.pmarlen.model.beans.Usuario> jpaUsuarioList = usuarioJPAController.findAllEntities();
		logger.debug("->getAllOfUsuario jpaUsuarioList is null ?"+(jpaUsuarioList==null));
		com.pmarlen.wscommons.services.dto.Usuario dtoUsuario = null;
		for(com.pmarlen.model.beans.Usuario xi: jpaUsuarioList){
			dtoUsuario = new com.pmarlen.wscommons.services.dto.Usuario(xi);			
			resultUsuarioList.add(dtoUsuario);
			logger.debug("->jpaUsuarioList \tadd dto:"+dtoUsuario);
		}
		result.setUsuarioList(resultUsuarioList);
		
		return result;
	}
}
