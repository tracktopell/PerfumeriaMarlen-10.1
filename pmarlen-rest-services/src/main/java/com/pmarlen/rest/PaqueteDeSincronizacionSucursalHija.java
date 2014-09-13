/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmarlen.rest;

import com.pmarlen.wscommons.services.dto.*;
import java.util.List;

/**
 *
 * @author alfredo
 */
public class PaqueteDeSincronizacionSucursalHija {
	private int tipoTransaccion;
	private List<Linea> lineaList;
	private List<Industria> industriaList;
	private List<Marca> marcaList;	
	private List<Producto> productoList;
	private List<Almacen> almacenList;
	private List<Sucursal> sucursalList;
	private List<AlmacenProducto> almacenProductoList;
	private List<Cliente> clienteList;
	private List<MetodoDePago> metodoDePagoList;
	private List<FormaDePago> formaDePagoList;
	private List<Perfil> perfilList;
	private List<Usuario> usuarioList;

	public PaqueteDeSincronizacionSucursalHija(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * @return the tipoTransaccion
	 */
	public int getTipoTransaccion() {
		return tipoTransaccion;
	}

	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * @return the lineaList
	 */
	public List<Linea> getLineaList() {
		return lineaList;
	}

	/**
	 * @param lineaList the lineaList to set
	 */
	public void setLineaList(List<Linea> lineaList) {
		this.lineaList = lineaList;
	}

	/**
	 * @return the industriaList
	 */
	public List<Industria> getIndustriaList() {
		return industriaList;
	}

	/**
	 * @param industriaList the industriaList to set
	 */
	public void setIndustriaList(List<Industria> industriaList) {
		this.industriaList = industriaList;
	}

	/**
	 * @return the marcaList
	 */
	public List<Marca> getMarcaList() {
		return marcaList;
	}

	/**
	 * @param marcaList the marcaList to set
	 */
	public void setMarcaList(List<Marca> marcaList) {
		this.marcaList = marcaList;
	}

	/**
	 * @return the productoList
	 */
	public List<Producto> getProductoList() {
		return productoList;
	}

	/**
	 * @param productoList the productoList to set
	 */
	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}

	/**
	 * @return the almacenList
	 */
	public List<Almacen> getAlmacenList() {
		return almacenList;
	}

	/**
	 * @param almacenList the almacenList to set
	 */
	public void setAlmacenList(List<Almacen> almacenList) {
		this.almacenList = almacenList;
	}

	/**
	 * @return the sucursalList
	 */
	public List<Sucursal> getSucursalList() {
		return sucursalList;
	}

	/**
	 * @param sucursalList the sucursalList to set
	 */
	public void setSucursalList(List<Sucursal> sucursalList) {
		this.sucursalList = sucursalList;
	}

	/**
	 * @return the almacenProductoList
	 */
	public List<AlmacenProducto> getAlmacenProductoList() {
		return almacenProductoList;
	}

	/**
	 * @param almacenProductoList the almacenProductoList to set
	 */
	public void setAlmacenProductoList(List<AlmacenProducto> almacenProductoList) {
		this.almacenProductoList = almacenProductoList;
	}

	/**
	 * @return the clienteList
	 */
	public List<Cliente> getClienteList() {
		return clienteList;
	}

	/**
	 * @param clienteList the clienteList to set
	 */
	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	/**
	 * @return the metodoDePagoList
	 */
	public List<MetodoDePago> getMetodoDePagoList() {
		return metodoDePagoList;
	}

	/**
	 * @param metodoDePagoList the metodoDePagoList to set
	 */
	public void setMetodoDePagoList(List<MetodoDePago> metodoDePagoList) {
		this.metodoDePagoList = metodoDePagoList;
	}

	/**
	 * @return the formaDePagoList
	 */
	public List<FormaDePago> getFormaDePagoList() {
		return formaDePagoList;
	}

	/**
	 * @param formaDePagoList the formaDePagoList to set
	 */
	public void setFormaDePagoList(List<FormaDePago> formaDePagoList) {
		this.formaDePagoList = formaDePagoList;
	}

	/**
	 * @return the perfilList
	 */
	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	/**
	 * @param perfilList the perfilList to set
	 */
	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	/**
	 * @return the usuarioList
	 */
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	/**
	 * @param usuarioList the usuarioList to set
	 */
	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
}
