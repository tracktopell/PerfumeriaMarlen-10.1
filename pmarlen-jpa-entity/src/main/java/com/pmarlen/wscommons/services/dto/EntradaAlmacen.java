
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
 * @date 2014/09/11 12:55
 */

public class EntradaAlmacen implements java.io.Serializable {
    private static final long serialVersionUID = 894522849;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * almacen id
    */
    private Integer almacenId;
    
    /**
    * usuario email
    */
    private String usuarioEmail;
    
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
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.almacenId = jpaEntity.getAlmacen()!=null?jpaEntity.getAlmacen().getId():null; // normalized 
        this.usuarioEmail = jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmail():null; // normalized 
        // this.fecha = jpaEntity.getFecha()!=null?jpaEntity.getFecha():null; // bug ?
        this.fecha = jpaEntity.getFecha(); // fixed
        // this.comentarios = jpaEntity.getComentarios()!=null?jpaEntity.getComentarios():null; // bug ?
        this.comentarios = jpaEntity.getComentarios(); // fixed
        // this.descuentoAplicado = jpaEntity.getDescuentoAplicado()!=null?jpaEntity.getDescuentoAplicado():null; // bug ?
        this.descuentoAplicado = jpaEntity.getDescuentoAplicado(); // fixed
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

    public String  getUsuarioEmail() {
        return this.usuarioEmail;
    }

    public void setUsuarioEmail(String id) {
        this.usuarioEmail = id;
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
        jpaEntity.setAlmacen( this.getAlmacenId()!=null? new com.pmarlen.model.beans.Almacen(this.getAlmacenId()):null); // normalized
        jpaEntity.setUsuario( this.getUsuarioEmail()!=null? new com.pmarlen.model.beans.Usuario(this.getUsuarioEmail()):null); // normalized
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
