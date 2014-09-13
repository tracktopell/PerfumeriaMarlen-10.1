
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

// import com.pmarlen.model.beans.MovimientoOperativoAlmacenDetalle;

/**
 * Class for mapping DTO Entity of Table Movimiento_operativo_almacen_Detalle.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class MovimientoOperativoAlmacenDetalle implements java.io.Serializable {
    private static final long serialVersionUID = 362764163;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * movimiento operativo almacen id
    */
    private Integer movimientoOperativoAlmacenId;
    
    /**
    * producto id
    */
    private Integer productoId;
    
    /**
    * cantidad
    */
    private int cantidad;

    /** 
     * Default Constructor
     */
    public MovimientoOperativoAlmacenDetalle() {
    }

    /** 
     * JPA Entity Constructor
     */
    public MovimientoOperativoAlmacenDetalle(com.pmarlen.model.beans.MovimientoOperativoAlmacenDetalle jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.movimientoOperativoAlmacenId = jpaEntity.getMovimientoOperativoAlmacen()!=null?jpaEntity.getMovimientoOperativoAlmacen().getId():null; // normalized 
        this.productoId = jpaEntity.getProducto()!=null?jpaEntity.getProducto().getId():null; // normalized 
        // this.cantidad = jpaEntity.getCantidad()!=null?jpaEntity.getCantidad():null; // bug ?
        this.cantidad = jpaEntity.getCantidad(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public MovimientoOperativoAlmacenDetalle( Integer id ) {
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

    public Integer  getMovimientoOperativoAlmacenId() {
        return this.movimientoOperativoAlmacenId;
    }

    public void setMovimientoOperativoAlmacenId(Integer id) {
        this.movimientoOperativoAlmacenId = id;
    }

    public Integer  getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Integer id) {
        this.productoId = id;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int v) {
        this.cantidad = v;
    }


    public com.pmarlen.model.beans.MovimientoOperativoAlmacenDetalle buildJpaEntity(){
        com.pmarlen.model.beans.MovimientoOperativoAlmacenDetalle jpaEntity = new com.pmarlen.model.beans.MovimientoOperativoAlmacenDetalle();

        jpaEntity.setId( this.getId());
        jpaEntity.setMovimientoOperativoAlmacen( this.getMovimientoOperativoAlmacenId()!=null? new com.pmarlen.model.beans.MovimientoOperativoAlmacen(this.getMovimientoOperativoAlmacenId()):null); // normalized
        jpaEntity.setProducto( this.getProductoId()!=null? new com.pmarlen.model.beans.Producto(this.getProductoId()):null); // normalized
        jpaEntity.setCantidad( this.getCantidad());

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
        if (!(o instanceof MovimientoOperativoAlmacenDetalle)) {
            return false;
        }

    	MovimientoOperativoAlmacenDetalle other = (MovimientoOperativoAlmacenDetalle ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.MovimientoOperativoAlmacenDetalle[id = "+id+ "]";
    }

}
