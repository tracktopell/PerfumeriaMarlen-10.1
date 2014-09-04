
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

// import com.pmarlen.model.beans.Almacen;

/**
 * Class for mapping DTO Entity of Table Almacen.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class Almacen implements java.io.Serializable {
    private static final long serialVersionUID = 304855538;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * sucursal id
    */
    private Integer sucursalId;
    
    /**
    * tipo almacen
    */
    private int tipoAlmacen;

    /** 
     * Default Constructor
     */
    public Almacen() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Almacen(com.pmarlen.model.beans.Almacen jpaEntity) {
        this.id = jpaEntity.getId();
        this.sucursalId = jpaEntity.getSucursal().getId(); // normalized 
        this.tipoAlmacen = jpaEntity.getTipoAlmacen();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Almacen( Integer id ) {
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

    public Integer  getSucursalId() {
        return this.sucursalId;
    }

    public void setSucursalId(Integer id) {
        this.sucursalId = id;
    }

    public int getTipoAlmacen() {
        return this.tipoAlmacen;
    }

    public void setTipoAlmacen(int v) {
        this.tipoAlmacen = v;
    }


    public com.pmarlen.model.beans.Almacen buildJpaEntity(){
        com.pmarlen.model.beans.Almacen jpaEntity = new com.pmarlen.model.beans.Almacen();

        jpaEntity.setId( this.getId());
        jpaEntity.setSucursal( new com.pmarlen.model.beans.Sucursal(this.getSucursalId())); // normalized
        jpaEntity.setTipoAlmacen( this.getTipoAlmacen());

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
        if (!(o instanceof Almacen)) {
            return false;
        }

    	Almacen other = (Almacen ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.Almacen[id = "+id+ "]";
    }

}
