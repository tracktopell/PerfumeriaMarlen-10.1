
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

// import com.pmarlen.model.beans.EntradaAlmacenDetalle;

/**
 * Class for mapping DTO Entity of Table Entrada_Almacen_Detalle.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class EntradaAlmacenDetalle implements java.io.Serializable {
    private static final long serialVersionUID = 1522268748;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * entrada almacen id
    */
    private Integer entradaAlmacenId;
    
    /**
    * producto id
    */
    private Integer productoId;
    
    /**
    * cantidad
    */
    private int cantidad;
    
    /**
    * precio venta
    */
    private double precioVenta;
    
    /**
    * costo
    */
    private double costo;

    /** 
     * Default Constructor
     */
    public EntradaAlmacenDetalle() {
    }

    /** 
     * JPA Entity Constructor
     */
    public EntradaAlmacenDetalle(com.pmarlen.model.beans.EntradaAlmacenDetalle jpaEntity) {
        this.id = jpaEntity.getId();
        this.entradaAlmacenId = jpaEntity.getEntradaAlmacen().getId(); // normalized 
        this.productoId = jpaEntity.getProducto().getId(); // normalized 
        this.cantidad = jpaEntity.getCantidad();
        this.precioVenta = jpaEntity.getPrecioVenta();
        this.costo = jpaEntity.getCosto();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public EntradaAlmacenDetalle( Integer id ) {
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

    public Integer  getEntradaAlmacenId() {
        return this.entradaAlmacenId;
    }

    public void setEntradaAlmacenId(Integer id) {
        this.entradaAlmacenId = id;
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

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double v) {
        this.precioVenta = v;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double v) {
        this.costo = v;
    }


    public com.pmarlen.model.beans.EntradaAlmacenDetalle buildJpaEntity(){
        com.pmarlen.model.beans.EntradaAlmacenDetalle jpaEntity = new com.pmarlen.model.beans.EntradaAlmacenDetalle();

        jpaEntity.setId( this.getId());
        jpaEntity.setEntradaAlmacen( new com.pmarlen.model.beans.EntradaAlmacen(this.getEntradaAlmacenId())); // normalized
        jpaEntity.setProducto( new com.pmarlen.model.beans.Producto(this.getProductoId())); // normalized
        jpaEntity.setCantidad( this.getCantidad());
        jpaEntity.setPrecioVenta( this.getPrecioVenta());
        jpaEntity.setCosto( this.getCosto());

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
        if (!(o instanceof EntradaAlmacenDetalle)) {
            return false;
        }

    	EntradaAlmacenDetalle other = (EntradaAlmacenDetalle ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.EntradaAlmacenDetalle[id = "+id+ "]";
    }

}
