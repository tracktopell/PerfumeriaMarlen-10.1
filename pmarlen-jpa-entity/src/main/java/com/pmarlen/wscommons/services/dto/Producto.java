
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

// import com.pmarlen.model.beans.Producto;

/**
 * Class for mapping DTO Entity of Table Producto.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class Producto implements java.io.Serializable {
    private static final long serialVersionUID = 83389031;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * codigo barras
    */
    private String codigoBarras;
    
    /**
    * marca id
    */
    private Integer marcaId;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * presentacion
    */
    private String presentacion;
    
    /**
    * unidades por caja
    */
    private int unidadesPorCaja;
    
    /**
    * unidad medida
    */
    private String unidadMedida;
    
    /**
    * costo
    */
    private double costo;
    
    /**
    * costo venta
    */
    private double costoVenta;
    
    /**
    * contenido
    */
    private String contenido;
    
    /**
    * abrebiatura
    */
    private String abrebiatura;
    
    /**
    * precio venta tmp
    */
    private Double precioVentaTmp;
    
    /**
    * cantidad actual tmp
    */
    private Integer cantidadActualTmp;

    /** 
     * Default Constructor
     */
    public Producto() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Producto(com.pmarlen.model.beans.Producto jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.codigoBarras = jpaEntity.getCodigoBarras()!=null?jpaEntity.getCodigoBarras():null; // bug ?
        this.codigoBarras = jpaEntity.getCodigoBarras(); // fixed
        this.marcaId = jpaEntity.getMarca()!=null?jpaEntity.getMarca().getId():null; // normalized 
        // this.nombre = jpaEntity.getNombre()!=null?jpaEntity.getNombre():null; // bug ?
        this.nombre = jpaEntity.getNombre(); // fixed
        // this.presentacion = jpaEntity.getPresentacion()!=null?jpaEntity.getPresentacion():null; // bug ?
        this.presentacion = jpaEntity.getPresentacion(); // fixed
        // this.unidadesPorCaja = jpaEntity.getUnidadesPorCaja()!=null?jpaEntity.getUnidadesPorCaja():null; // bug ?
        this.unidadesPorCaja = jpaEntity.getUnidadesPorCaja(); // fixed
        // this.unidadMedida = jpaEntity.getUnidadMedida()!=null?jpaEntity.getUnidadMedida():null; // bug ?
        this.unidadMedida = jpaEntity.getUnidadMedida(); // fixed
        // this.costo = jpaEntity.getCosto()!=null?jpaEntity.getCosto():null; // bug ?
        this.costo = jpaEntity.getCosto(); // fixed
        // this.costoVenta = jpaEntity.getCostoVenta()!=null?jpaEntity.getCostoVenta():null; // bug ?
        this.costoVenta = jpaEntity.getCostoVenta(); // fixed
        // this.contenido = jpaEntity.getContenido()!=null?jpaEntity.getContenido():null; // bug ?
        this.contenido = jpaEntity.getContenido(); // fixed
        // this.abrebiatura = jpaEntity.getAbrebiatura()!=null?jpaEntity.getAbrebiatura():null; // bug ?
        this.abrebiatura = jpaEntity.getAbrebiatura(); // fixed
        // this.precioVentaTmp = jpaEntity.getPrecioVentaTmp()!=null?jpaEntity.getPrecioVentaTmp():null; // bug ?
        this.precioVentaTmp = jpaEntity.getPrecioVentaTmp(); // fixed
        // this.cantidadActualTmp = jpaEntity.getCantidadActualTmp()!=null?jpaEntity.getCantidadActualTmp():null; // bug ?
        this.cantidadActualTmp = jpaEntity.getCantidadActualTmp(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Producto( Integer id ) {
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

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public void setCodigoBarras(String v) {
        this.codigoBarras = v;
    }

    public Integer  getMarcaId() {
        return this.marcaId;
    }

    public void setMarcaId(Integer id) {
        this.marcaId = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String v) {
        this.nombre = v;
    }

    public String getPresentacion() {
        return this.presentacion;
    }

    public void setPresentacion(String v) {
        this.presentacion = v;
    }

    public int getUnidadesPorCaja() {
        return this.unidadesPorCaja;
    }

    public void setUnidadesPorCaja(int v) {
        this.unidadesPorCaja = v;
    }

    public String getUnidadMedida() {
        return this.unidadMedida;
    }

    public void setUnidadMedida(String v) {
        this.unidadMedida = v;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double v) {
        this.costo = v;
    }

    public double getCostoVenta() {
        return this.costoVenta;
    }

    public void setCostoVenta(double v) {
        this.costoVenta = v;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String v) {
        this.contenido = v;
    }

    public String getAbrebiatura() {
        return this.abrebiatura;
    }

    public void setAbrebiatura(String v) {
        this.abrebiatura = v;
    }

    public Double getPrecioVentaTmp() {
        return this.precioVentaTmp;
    }

    public void setPrecioVentaTmp(Double v) {
        this.precioVentaTmp = v;
    }

    public Integer getCantidadActualTmp() {
        return this.cantidadActualTmp;
    }

    public void setCantidadActualTmp(Integer v) {
        this.cantidadActualTmp = v;
    }


    public com.pmarlen.model.beans.Producto buildJpaEntity(){
        com.pmarlen.model.beans.Producto jpaEntity = new com.pmarlen.model.beans.Producto();

        jpaEntity.setId( this.getId());
        jpaEntity.setCodigoBarras( this.getCodigoBarras());
        jpaEntity.setMarca( this.getMarcaId()!=null? new com.pmarlen.model.beans.Marca(this.getMarcaId()):null); // normalized
        jpaEntity.setNombre( this.getNombre());
        jpaEntity.setPresentacion( this.getPresentacion());
        jpaEntity.setUnidadesPorCaja( this.getUnidadesPorCaja());
        jpaEntity.setUnidadMedida( this.getUnidadMedida());
        jpaEntity.setCosto( this.getCosto());
        jpaEntity.setCostoVenta( this.getCostoVenta());
        jpaEntity.setContenido( this.getContenido());
        jpaEntity.setAbrebiatura( this.getAbrebiatura());
        jpaEntity.setPrecioVentaTmp( this.getPrecioVentaTmp());
        jpaEntity.setCantidadActualTmp( this.getCantidadActualTmp());

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
        if (!(o instanceof Producto)) {
            return false;
        }

    	Producto other = (Producto ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombre + ", " + presentacion;
    }

}
