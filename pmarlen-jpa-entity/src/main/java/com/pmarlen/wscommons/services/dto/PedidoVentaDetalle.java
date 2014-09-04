
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

// import com.pmarlen.model.beans.PedidoVentaDetalle;

/**
 * Class for mapping DTO Entity of Table Pedido_Venta_Detalle.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class PedidoVentaDetalle implements java.io.Serializable {
    private static final long serialVersionUID = 1183200438;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * pedido venta id
    */
    private Integer pedidoVentaId;
    
    /**
    * almacen id
    */
    private Integer almacenId;
    
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
     * Default Constructor
     */
    public PedidoVentaDetalle() {
    }

    /** 
     * JPA Entity Constructor
     */
    public PedidoVentaDetalle(com.pmarlen.model.beans.PedidoVentaDetalle jpaEntity) {
        this.id = jpaEntity.getId();
        this.pedidoVentaId = jpaEntity.getPedidoVenta().getId(); // normalized 
        this.almacenId = jpaEntity.getAlmacen().getId(); // normalized 
        this.productoId = jpaEntity.getProducto().getId(); // normalized 
        this.cantidad = jpaEntity.getCantidad();
        this.precioVenta = jpaEntity.getPrecioVenta();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public PedidoVentaDetalle( Integer id ) {
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

    public Integer  getPedidoVentaId() {
        return this.pedidoVentaId;
    }

    public void setPedidoVentaId(Integer id) {
        this.pedidoVentaId = id;
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


    public com.pmarlen.model.beans.PedidoVentaDetalle buildJpaEntity(){
        com.pmarlen.model.beans.PedidoVentaDetalle jpaEntity = new com.pmarlen.model.beans.PedidoVentaDetalle();

        jpaEntity.setId( this.getId());
        jpaEntity.setPedidoVenta( new com.pmarlen.model.beans.PedidoVenta(this.getPedidoVentaId())); // normalized
        jpaEntity.setAlmacen( new com.pmarlen.model.beans.Almacen(this.getAlmacenId())); // normalized
        jpaEntity.setProducto( new com.pmarlen.model.beans.Producto(this.getProductoId())); // normalized
        jpaEntity.setCantidad( this.getCantidad());
        jpaEntity.setPrecioVenta( this.getPrecioVenta());

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
        if (!(o instanceof PedidoVentaDetalle)) {
            return false;
        }

    	PedidoVentaDetalle other = (PedidoVentaDetalle ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.PedidoVentaDetalle[id = "+id+ "]";
    }

}
