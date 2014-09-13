
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

// import com.pmarlen.model.beans.AlmacenProducto;

/**
 * Class for mapping DTO Entity of Table Almacen_Producto.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class AlmacenProducto implements java.io.Serializable {
    private static final long serialVersionUID = 166440805;
    
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
    * cantidad actual
    */
    private int cantidadActual;
    
    /**
    * precio venta
    */
    private double precioVenta;
    
    /**
    * precio mayoreo
    */
    private double precioMayoreo;
    
    /**
    * costo
    */
    private Double costo;

    /** 
     * Default Constructor
     */
    public AlmacenProducto() {
    }

    /** 
     * JPA Entity Constructor
     */
    public AlmacenProducto(com.pmarlen.model.beans.AlmacenProducto jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.almacenId = jpaEntity.getAlmacen()!=null?jpaEntity.getAlmacen().getId():null; // normalized 
        this.productoId = jpaEntity.getProducto()!=null?jpaEntity.getProducto().getId():null; // normalized 
        // this.cantidadActual = jpaEntity.getCantidadActual()!=null?jpaEntity.getCantidadActual():null; // bug ?
        this.cantidadActual = jpaEntity.getCantidadActual(); // fixed
        // this.precioVenta = jpaEntity.getPrecioVenta()!=null?jpaEntity.getPrecioVenta():null; // bug ?
        this.precioVenta = jpaEntity.getPrecioVenta(); // fixed
        // this.precioMayoreo = jpaEntity.getPrecioMayoreo()!=null?jpaEntity.getPrecioMayoreo():null; // bug ?
        this.precioMayoreo = jpaEntity.getPrecioMayoreo(); // fixed
        // this.costo = jpaEntity.getCosto()!=null?jpaEntity.getCosto():null; // bug ?
        this.costo = jpaEntity.getCosto(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public AlmacenProducto( Integer id ) {
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

    public int getCantidadActual() {
        return this.cantidadActual;
    }

    public void setCantidadActual(int v) {
        this.cantidadActual = v;
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double v) {
        this.precioVenta = v;
    }

    public double getPrecioMayoreo() {
        return this.precioMayoreo;
    }

    public void setPrecioMayoreo(double v) {
        this.precioMayoreo = v;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double v) {
        this.costo = v;
    }


    public com.pmarlen.model.beans.AlmacenProducto buildJpaEntity(){
        com.pmarlen.model.beans.AlmacenProducto jpaEntity = new com.pmarlen.model.beans.AlmacenProducto();

        jpaEntity.setId( this.getId());
        jpaEntity.setAlmacen( this.getAlmacenId()!=null? new com.pmarlen.model.beans.Almacen(this.getAlmacenId()):null); // normalized
        jpaEntity.setProducto( this.getProductoId()!=null? new com.pmarlen.model.beans.Producto(this.getProductoId()):null); // normalized
        jpaEntity.setCantidadActual( this.getCantidadActual());
        jpaEntity.setPrecioVenta( this.getPrecioVenta());
        jpaEntity.setPrecioMayoreo( this.getPrecioMayoreo());
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
        if (!(o instanceof AlmacenProducto)) {
            return false;
        }

    	AlmacenProducto other = (AlmacenProducto ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.AlmacenProducto[id = "+id+ "]";
    }

}
