
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

// import com.pmarlen.model.beans.EntradaAlmacen;

/**
 * Class for mapping DTO Entity of Table Entrada_almacen.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class EntradaAlmacen implements java.io.Serializable {
    private static final long serialVersionUID = 1590125579;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * almacen id
    */
    private Integer almacenId;
    
    /**
    * usuario id
    */
    private String usuarioId;
    
    /**
    * fecha
    */
    private java.util.Date fecha;
    
    /**
    * comentarios
    */
    private String comentarios;
    
    /**
    * descuento aplicado
    */
    private Double descuentoAplicado;

    /** 
     * Default Constructor
     */
    public EntradaAlmacen() {
    }

    /** 
     * JPA Entity Constructor
     */
    public EntradaAlmacen(com.pmarlen.model.beans.EntradaAlmacen jpaEntity) {
        this.id = jpaEntity.getId();
        this.almacenId = jpaEntity.getAlmacen().getId(); // normalized 
        this.usuarioId = jpaEntity.getUsuario().getId(); // normalized 
        this.fecha = jpaEntity.getFecha();
        this.comentarios = jpaEntity.getComentarios();
        this.descuentoAplicado = jpaEntity.getDescuentoAplicado();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public EntradaAlmacen( Integer id ) {
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

    public String  getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(String id) {
        this.usuarioId = id;
    }

    public java.util.Date getFecha() {
        return this.fecha;
    }

    public void setFecha(java.util.Date v) {
        this.fecha = v;
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


    public com.pmarlen.model.beans.EntradaAlmacen buildJpaEntity(){
        com.pmarlen.model.beans.EntradaAlmacen jpaEntity = new com.pmarlen.model.beans.EntradaAlmacen();

        jpaEntity.setId( this.getId());
        jpaEntity.setAlmacen( new com.pmarlen.model.beans.Almacen(this.getAlmacenId())); // normalized
        jpaEntity.setUsuario( new com.pmarlen.model.beans.Usuario(this.getUsuarioId())); // normalized
        jpaEntity.setFecha( this.getFecha());
        jpaEntity.setComentarios( this.getComentarios());
        jpaEntity.setDescuentoAplicado( this.getDescuentoAplicado());

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
        if (!(o instanceof EntradaAlmacen)) {
            return false;
        }

    	EntradaAlmacen other = (EntradaAlmacen ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.EntradaAlmacen[id = "+id+ "]";
    }

}
