
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

// import com.pmarlen.model.beans.Perfil;

/**
 * Class for mapping DTO Entity of Table Perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class Perfil implements java.io.Serializable {
    private static final long serialVersionUID = 621779526;
    
    /**
    * id
    */
    private String id;
    
    /**
    * descripcion
    */
    private String descripcion;

    /** 
     * Default Constructor
     */
    public Perfil() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Perfil(com.pmarlen.model.beans.Perfil jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.descripcion = jpaEntity.getDescripcion()!=null?jpaEntity.getDescripcion():null; // bug ?
        this.descripcion = jpaEntity.getDescripcion(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Perfil( String id ) {
        this.id 	= 	id;

    }
    
    /**
     * Getters and Setters
     */
    public String getId() {
        return this.id;
    }

    public void setId(String v) {
        this.id = v;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String v) {
        this.descripcion = v;
    }


    public com.pmarlen.model.beans.Perfil buildJpaEntity(){
        com.pmarlen.model.beans.Perfil jpaEntity = new com.pmarlen.model.beans.Perfil();

        jpaEntity.setId( this.getId());
        jpaEntity.setDescripcion( this.getDescripcion());

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
        if (!(o instanceof Perfil)) {
            return false;
        }

    	Perfil other = (Perfil ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.Perfil[id = "+id+ "]";
    }

}
