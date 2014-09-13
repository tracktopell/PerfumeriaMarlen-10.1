
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

// import com.pmarlen.model.beans.MovimientoHistoricoProducto;

/**
 * Class for mapping DTO Entity of Table Movimiento_Historico_Producto.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class MovimientoHistoricoProducto implements java.io.Serializable {
    private static final long serialVersionUID = 14795687;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * almacen id
    */
    private Integer almacenId;
    
    /**
    * producto id
    */
    private Integer productoId;
    
    /**
    * fecha
    */
    private java.util.Date fecha;
    
    /**
    * tipo movimiento
    */
    private int tipoMovimiento;
    
    /**
    * cantidad
    */
    private int cantidad;
    
    /**
    * costo
    */
    private Double costo;
    
    /**
    * precio
    */
    private Double precio;
    
    /**
    * usuario email
    */
    private String usuarioEmail;

    /** 
     * Default Constructor
     */
    public MovimientoHistoricoProducto() {
    }

    /** 
     * JPA Entity Constructor
     */
    public MovimientoHistoricoProducto(com.pmarlen.model.beans.MovimientoHistoricoProducto jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.almacenId = jpaEntity.getAlmacen()!=null?jpaEntity.getAlmacen().getId():null; // normalized 
        this.productoId = jpaEntity.getProducto()!=null?jpaEntity.getProducto().getId():null; // normalized 
        // this.fecha = jpaEntity.getFecha()!=null?jpaEntity.getFecha():null; // bug ?
        this.fecha = jpaEntity.getFecha(); // fixed
        // this.tipoMovimiento = jpaEntity.getTipoMovimiento()!=null?jpaEntity.getTipoMovimiento():null; // bug ?
        this.tipoMovimiento = jpaEntity.getTipoMovimiento(); // fixed
        // this.cantidad = jpaEntity.getCantidad()!=null?jpaEntity.getCantidad():null; // bug ?
        this.cantidad = jpaEntity.getCantidad(); // fixed
        // this.costo = jpaEntity.getCosto()!=null?jpaEntity.getCosto():null; // bug ?
        this.costo = jpaEntity.getCosto(); // fixed
        // this.precio = jpaEntity.getPrecio()!=null?jpaEntity.getPrecio():null; // bug ?
        this.precio = jpaEntity.getPrecio(); // fixed
        this.usuarioEmail = jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmail():null; // normalized 
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public MovimientoHistoricoProducto( Integer id ) {
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

    public Integer  getAlmacenId() {
        return this.almacenId;
    }

    public void setAlmacenId(Integer id) {
        this.almacenId = id;
    }

    public Integer  getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Integer id) {
        this.productoId = id;
    }

    public java.util.Date getFecha() {
        return this.fecha;
    }

    public void setFecha(java.util.Date v) {
        this.fecha = v;
    }

    public int getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(int v) {
        this.tipoMovimiento = v;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int v) {
        this.cantidad = v;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double v) {
        this.costo = v;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double v) {
        this.precio = v;
    }

    public String  getUsuarioEmail() {
        return this.usuarioEmail;
    }

    public void setUsuarioEmail(String id) {
        this.usuarioEmail = id;
    }


    public com.pmarlen.model.beans.MovimientoHistoricoProducto buildJpaEntity(){
        com.pmarlen.model.beans.MovimientoHistoricoProducto jpaEntity = new com.pmarlen.model.beans.MovimientoHistoricoProducto();

        jpaEntity.setId( this.getId());
        jpaEntity.setAlmacen( this.getAlmacenId()!=null? new com.pmarlen.model.beans.Almacen(this.getAlmacenId()):null); // normalized
        jpaEntity.setProducto( this.getProductoId()!=null? new com.pmarlen.model.beans.Producto(this.getProductoId()):null); // normalized
        jpaEntity.setFecha( this.getFecha());
        jpaEntity.setTipoMovimiento( this.getTipoMovimiento());
        jpaEntity.setCantidad( this.getCantidad());
        jpaEntity.setCosto( this.getCosto());
        jpaEntity.setPrecio( this.getPrecio());
        jpaEntity.setUsuario( this.getUsuarioEmail()!=null? new com.pmarlen.model.beans.Usuario(this.getUsuarioEmail()):null); // normalized

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
        if (!(o instanceof MovimientoHistoricoProducto)) {
            return false;
        }

    	MovimientoHistoricoProducto other = (MovimientoHistoricoProducto ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.MovimientoHistoricoProducto[id = "+id+ "]";
    }

}
