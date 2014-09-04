
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

// import com.pmarlen.model.beans.Linea;

/**
 * Class for mapping DTO Entity of Table Linea.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class Linea implements java.io.Serializable {
    private static final long serialVersionUID = 248808824;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * nombre
    */
    private String nombre;

    /** 
     * Default Constructor
     */
    public Linea() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Linea(com.pmarlen.model.beans.Linea jpaEntity) {
        this.id = jpaEntity.getId();
        this.nombre = jpaEntity.getNombre();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Linea( Integer id ) {
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String v) {
        this.nombre = v;
    }


    public com.pmarlen.model.beans.Linea buildJpaEntity(){
        com.pmarlen.model.beans.Linea jpaEntity = new com.pmarlen.model.beans.Linea();

        jpaEntity.setId( this.getId());
        jpaEntity.setNombre( this.getNombre());

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
        if (!(o instanceof Linea)) {
            return false;
        }

    	Linea other = (Linea ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
