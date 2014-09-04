
package com.pmarlen.wscommons.services.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.Collection;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// import com.pmarlen.model.beans.PedidoVenta;

/**
 * Class for mapping DTO Entity of Table Pedido_Venta.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class PedidoVenta implements java.io.Serializable {
    private static final long serialVersionUID = 2008272604;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * estado
    */
    private int estado;
    
    /**
    * fecha actualizacion
    */
    private java.util.Date fechaActualizacion;
    
    /**
    * usuario id
    */
    private String usuarioId;
    
    /**
    * cliente id
    */
    private Integer clienteId;
    
    /**
    * forma de pago id
    */
    private Integer formaDePagoId;
    
    /**
    * metodo de pago id
    */
    private Integer metodoDePagoId;
    
    /**
    * factoriva
    */
    private double factoriva;
    
    /**
    * comentarios
    */
    private String comentarios;
    
    /**
    * descuento aplicado
    */
    private Double descuentoAplicado;
    
    /**
    * facturable
    */
    private Integer facturable;
    
    /**
    * cfd venta id
    */
    private Integer cfdVentaId;
    
    /**
    * numero ticket
    */
    private String numeroTicket;
    
    /**
    * caja
    */
    private Integer caja;
    
    /**
    * importe recibido
    */
    private Double importeRecibido;
    
    /**
    * aprobacion visa mastercard
    */
    private String aprobacionVisaMastercard;
    
    /**
    * mayoreo
    */
    private Integer mayoreo;
    
    /**
    * porcentaje descuento calculado
    */
    private Integer porcentajeDescuentoCalculado;
    
    /**
    * porcentaje descuento extra
    */
    private Integer porcentajeDescuentoExtra;
    
    /**
    * condiciones de pago
    */
    private String condicionesDePago;
    
    /**
    * num de cuenta
    */
    private String numDeCuenta;
    
    /**
    * motivo descuento
    */
    private String motivoDescuento;

    /** 
     * Default Constructor
     */
    public PedidoVenta() {
    }

    /** 
     * JPA Entity Constructor
     */
    public PedidoVenta(com.pmarlen.model.beans.PedidoVenta jpaEntity) {
        this.id = jpaEntity.getId();
        this.estado = jpaEntity.getEstado();
        this.fechaActualizacion = jpaEntity.getFechaActualizacion();
        this.usuarioId = jpaEntity.getUsuario().getId(); // normalized 
        this.clienteId = jpaEntity.getCliente().getId(); // normalized 
        this.formaDePagoId = jpaEntity.getFormaDePago().getId(); // normalized 
        this.metodoDePagoId = jpaEntity.getMetodoDePago().getId(); // normalized 
        this.factoriva = jpaEntity.getFactoriva();
        this.comentarios = jpaEntity.getComentarios();
        this.descuentoAplicado = jpaEntity.getDescuentoAplicado();
        this.facturable = jpaEntity.getFacturable();
        this.cfdVentaId = jpaEntity.getCfdVenta().getId(); // normalized 
        this.numeroTicket = jpaEntity.getNumeroTicket();
        this.caja = jpaEntity.getCaja();
        this.importeRecibido = jpaEntity.getImporteRecibido();
        this.aprobacionVisaMastercard = jpaEntity.getAprobacionVisaMastercard();
        this.mayoreo = jpaEntity.getMayoreo();
        this.porcentajeDescuentoCalculado = jpaEntity.getPorcentajeDescuentoCalculado();
        this.porcentajeDescuentoExtra = jpaEntity.getPorcentajeDescuentoExtra();
        this.condicionesDePago = jpaEntity.getCondicionesDePago();
        this.numDeCuenta = jpaEntity.getNumDeCuenta();
        this.motivoDescuento = jpaEntity.getMotivoDescuento();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public PedidoVenta( Integer id ) {
        this.id 	= 	id;

    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer v) {
        this.id = v;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int v) {
        this.estado = v;
    }

    public java.util.Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(java.util.Date v) {
        this.fechaActualizacion = v;
    }

    public String  getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(String id) {
        this.usuarioId = id;
    }

    public Integer  getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Integer id) {
        this.clienteId = id;
    }

    public Integer  getFormaDePagoId() {
        return this.formaDePagoId;
    }

    public void setFormaDePagoId(Integer id) {
        this.formaDePagoId = id;
    }

    public Integer  getMetodoDePagoId() {
        return this.metodoDePagoId;
    }

    public void setMetodoDePagoId(Integer id) {
        this.metodoDePagoId = id;
    }

    public double getFactoriva() {
        return this.factoriva;
    }

    public void setFactoriva(double v) {
        this.factoriva = v;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String v) {
        this.comentarios = v;
    }

    public Double getDescuentoAplicado() {
        return this.descuentoAplicado;
    }

    public void setDescuentoAplicado(Double v) {
        this.descuentoAplicado = v;
    }

    public Integer getFacturable() {
        return this.facturable;
    }

    public void setFacturable(Integer v) {
        this.facturable = v;
    }

    public Integer  getCfdVentaId() {
        return this.cfdVentaId;
    }

    public void setCfdVentaId(Integer id) {
        this.cfdVentaId = id;
    }

    public String getNumeroTicket() {
        return this.numeroTicket;
    }

    public void setNumeroTicket(String v) {
        this.numeroTicket = v;
    }

    public Integer getCaja() {
        return this.caja;
    }

    public void setCaja(Integer v) {
        this.caja = v;
    }

    public Double getImporteRecibido() {
        return this.importeRecibido;
    }

    public void setImporteRecibido(Double v) {
        this.importeRecibido = v;
    }

    public String getAprobacionVisaMastercard() {
        return this.aprobacionVisaMastercard;
    }

    public void setAprobacionVisaMastercard(String v) {
        this.aprobacionVisaMastercard = v;
    }

    public Integer getMayoreo() {
        return this.mayoreo;
    }

    public void setMayoreo(Integer v) {
        this.mayoreo = v;
    }

    public Integer getPorcentajeDescuentoCalculado() {
        return this.porcentajeDescuentoCalculado;
    }

    public void setPorcentajeDescuentoCalculado(Integer v) {
        this.porcentajeDescuentoCalculado = v;
    }

    public Integer getPorcentajeDescuentoExtra() {
        return this.porcentajeDescuentoExtra;
    }

    public void setPorcentajeDescuentoExtra(Integer v) {
        this.porcentajeDescuentoExtra = v;
    }

    public String getCondicionesDePago() {
        return this.condicionesDePago;
    }

    public void setCondicionesDePago(String v) {
        this.condicionesDePago = v;
    }

    public String getNumDeCuenta() {
        return this.numDeCuenta;
    }

    public void setNumDeCuenta(String v) {
        this.numDeCuenta = v;
    }

    public String getMotivoDescuento() {
        return this.motivoDescuento;
    }

    public void setMotivoDescuento(String v) {
        this.motivoDescuento = v;
    }


    public com.pmarlen.model.beans.PedidoVenta buildJpaEntity(){
        com.pmarlen.model.beans.PedidoVenta jpaEntity = new com.pmarlen.model.beans.PedidoVenta();

        jpaEntity.setId( this.getId());
        jpaEntity.setEstado( this.getEstado());
        jpaEntity.setFechaActualizacion( this.getFechaActualizacion());
        jpaEntity.setUsuario( new com.pmarlen.model.beans.Usuario(this.getUsuarioId())); // normalized
        jpaEntity.setCliente( new com.pmarlen.model.beans.Cliente(this.getClienteId())); // normalized
        jpaEntity.setFormaDePago( new com.pmarlen.model.beans.FormaDePago(this.getFormaDePagoId())); // normalized
        jpaEntity.setMetodoDePago( new com.pmarlen.model.beans.MetodoDePago(this.getMetodoDePagoId())); // normalized
        jpaEntity.setFactoriva( this.getFactoriva());
        jpaEntity.setComentarios( this.getComentarios());
        jpaEntity.setDescuentoAplicado( this.getDescuentoAplicado());
        jpaEntity.setFacturable( this.getFacturable());
        jpaEntity.setCfdVenta( new com.pmarlen.model.beans.CfdVenta(this.getCfdVentaId())); // normalized
        jpaEntity.setNumeroTicket( this.getNumeroTicket());
        jpaEntity.setCaja( this.getCaja());
        jpaEntity.setImporteRecibido( this.getImporteRecibido());
        jpaEntity.setAprobacionVisaMastercard( this.getAprobacionVisaMastercard());
        jpaEntity.setMayoreo( this.getMayoreo());
        jpaEntity.setPorcentajeDescuentoCalculado( this.getPorcentajeDescuentoCalculado());
        jpaEntity.setPorcentajeDescuentoExtra( this.getPorcentajeDescuentoExtra());
        jpaEntity.setCondicionesDePago( this.getCondicionesDePago());
        jpaEntity.setNumDeCuenta( this.getNumDeCuenta());
        jpaEntity.setMotivoDescuento( this.getMotivoDescuento());

        return jpaEntity;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash = (id != null ? id.hashCode() : 0 );
        return hash;
    }

    public boolean equals(Object o){

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof PedidoVenta)) {
            return false;
        }

    	PedidoVenta other = (PedidoVenta ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.PedidoVenta[id = "+id+ "]";
    }

}
