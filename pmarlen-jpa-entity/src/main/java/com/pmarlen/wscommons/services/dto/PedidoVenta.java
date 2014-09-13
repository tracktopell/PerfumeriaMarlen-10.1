
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
 * @date 2014/09/11 12:55
 */

public class PedidoVenta implements java.io.Serializable {
    private static final long serialVersionUID = 1634386214;
    
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
    * usuario email
    */
    private String usuarioEmail;
    
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
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.estado = jpaEntity.getEstado()!=null?jpaEntity.getEstado():null; // bug ?
        this.estado = jpaEntity.getEstado(); // fixed
        // this.fechaActualizacion = jpaEntity.getFechaActualizacion()!=null?jpaEntity.getFechaActualizacion():null; // bug ?
        this.fechaActualizacion = jpaEntity.getFechaActualizacion(); // fixed
        this.usuarioEmail = jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmail():null; // normalized 
        this.clienteId = jpaEntity.getCliente()!=null?jpaEntity.getCliente().getId():null; // normalized 
        this.formaDePagoId = jpaEntity.getFormaDePago()!=null?jpaEntity.getFormaDePago().getId():null; // normalized 
        this.metodoDePagoId = jpaEntity.getMetodoDePago()!=null?jpaEntity.getMetodoDePago().getId():null; // normalized 
        // this.factoriva = jpaEntity.getFactoriva()!=null?jpaEntity.getFactoriva():null; // bug ?
        this.factoriva = jpaEntity.getFactoriva(); // fixed
        // this.comentarios = jpaEntity.getComentarios()!=null?jpaEntity.getComentarios():null; // bug ?
        this.comentarios = jpaEntity.getComentarios(); // fixed
        // this.descuentoAplicado = jpaEntity.getDescuentoAplicado()!=null?jpaEntity.getDescuentoAplicado():null; // bug ?
        this.descuentoAplicado = jpaEntity.getDescuentoAplicado(); // fixed
        // this.facturable = jpaEntity.getFacturable()!=null?jpaEntity.getFacturable():null; // bug ?
        this.facturable = jpaEntity.getFacturable(); // fixed
        this.cfdVentaId = jpaEntity.getCfdVenta()!=null?jpaEntity.getCfdVenta().getId():null; // normalized 
        // this.numeroTicket = jpaEntity.getNumeroTicket()!=null?jpaEntity.getNumeroTicket():null; // bug ?
        this.numeroTicket = jpaEntity.getNumeroTicket(); // fixed
        // this.caja = jpaEntity.getCaja()!=null?jpaEntity.getCaja():null; // bug ?
        this.caja = jpaEntity.getCaja(); // fixed
        // this.importeRecibido = jpaEntity.getImporteRecibido()!=null?jpaEntity.getImporteRecibido():null; // bug ?
        this.importeRecibido = jpaEntity.getImporteRecibido(); // fixed
        // this.aprobacionVisaMastercard = jpaEntity.getAprobacionVisaMastercard()!=null?jpaEntity.getAprobacionVisaMastercard():null; // bug ?
        this.aprobacionVisaMastercard = jpaEntity.getAprobacionVisaMastercard(); // fixed
        // this.mayoreo = jpaEntity.getMayoreo()!=null?jpaEntity.getMayoreo():null; // bug ?
        this.mayoreo = jpaEntity.getMayoreo(); // fixed
        // this.porcentajeDescuentoCalculado = jpaEntity.getPorcentajeDescuentoCalculado()!=null?jpaEntity.getPorcentajeDescuentoCalculado():null; // bug ?
        this.porcentajeDescuentoCalculado = jpaEntity.getPorcentajeDescuentoCalculado(); // fixed
        // this.porcentajeDescuentoExtra = jpaEntity.getPorcentajeDescuentoExtra()!=null?jpaEntity.getPorcentajeDescuentoExtra():null; // bug ?
        this.porcentajeDescuentoExtra = jpaEntity.getPorcentajeDescuentoExtra(); // fixed
        // this.condicionesDePago = jpaEntity.getCondicionesDePago()!=null?jpaEntity.getCondicionesDePago():null; // bug ?
        this.condicionesDePago = jpaEntity.getCondicionesDePago(); // fixed
        // this.numDeCuenta = jpaEntity.getNumDeCuenta()!=null?jpaEntity.getNumDeCuenta():null; // bug ?
        this.numDeCuenta = jpaEntity.getNumDeCuenta(); // fixed
        // this.motivoDescuento = jpaEntity.getMotivoDescuento()!=null?jpaEntity.getMotivoDescuento():null; // bug ?
        this.motivoDescuento = jpaEntity.getMotivoDescuento(); // fixed
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

    public String  getUsuarioEmail() {
        return this.usuarioEmail;
    }

    public void setUsuarioEmail(String id) {
        this.usuarioEmail = id;
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
        jpaEntity.setUsuario( this.getUsuarioEmail()!=null? new com.pmarlen.model.beans.Usuario(this.getUsuarioEmail()):null); // normalized
        jpaEntity.setCliente( this.getClienteId()!=null? new com.pmarlen.model.beans.Cliente(this.getClienteId()):null); // normalized
        jpaEntity.setFormaDePago( this.getFormaDePagoId()!=null? new com.pmarlen.model.beans.FormaDePago(this.getFormaDePagoId()):null); // normalized
        jpaEntity.setMetodoDePago( this.getMetodoDePagoId()!=null? new com.pmarlen.model.beans.MetodoDePago(this.getMetodoDePagoId()):null); // normalized
        jpaEntity.setFactoriva( this.getFactoriva());
        jpaEntity.setComentarios( this.getComentarios());
        jpaEntity.setDescuentoAplicado( this.getDescuentoAplicado());
        jpaEntity.setFacturable( this.getFacturable());
        jpaEntity.setCfdVenta( this.getCfdVentaId()!=null? new com.pmarlen.model.beans.CfdVenta(this.getCfdVentaId()):null); // normalized
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
