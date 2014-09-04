
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
 * @date 2014/08/27 07:01
 */

public class MovimientoHistoricoProducto implements java.io.Serializable {
    private static final long serialVersionUID = 753313597;
    
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
    * usuario id
    */
    private String usuarioId;

    /** 
     * Default Constructor
     */
    public MovimientoHistoricoProducto() {
    }

    /** 
     * JPA Entity Constructor
     */
    public MovimientoHistoricoProducto(com.pmarlen.model.beans.MovimientoHistoricoProducto jpaEntity) {
        this.id = jpaEntity.getId();
        this.almacenId = jpaEntity.getAlmacen().getId(); // normalized 
        this.productoId = jpaEntity.getProducto().getId(); // normalized 
        this.fecha = jpaEntity.getFecha();
        this.tipoMovimiento = jpaEntity.getTipoMovimiento();
        this.cantidad = jpaEntity.getCantidad();
        this.costo = jpaEntity.getCosto();
        this.precio = jpaEntity.getPrecio();
        this.usuarioId = jpaEntity.getUsuario().getId(); // normalized 
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

    public String  getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(String id) {
        this.usuarioId = id;
    }


    public com.pmarlen.model.beans.MovimientoHistoricoProducto buildJpaEntity(){
        com.pmarlen.model.beans.MovimientoHistoricoProducto jpaEntity = new com.pmarlen.model.beans.MovimientoHistoricoProducto();

        jpaEntity.setId( this.getId());
        jpaEntity.setAlmacen( new com.pmarlen.model.beans.Almacen(this.getAlmacenId())); // normalized
        jpaEntity.setProducto( new com.pmarlen.model.beans.Producto(this.getProductoId())); // normalized
        jpaEntity.setFecha( this.getFecha());
        jpaEntity.setTipoMovimiento( this.getTipoMovimiento());
        jpaEntity.setCantidad( this.getCantidad());
        jpaEntity.setCosto( this.getCosto());
        jpaEntity.setPrecio( this.getPrecio());
        jpaEntity.setUsuario( new com.pmarlen.model.beans.Usuario(this.getUsuarioId())); // normalized

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
