
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

// import com.pmarlen.model.beans.Marca;

/**
 * Class for mapping DTO Entity of Table Marca.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class Marca implements java.io.Serializable {
    private static final long serialVersionUID = 1137015402;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * industria id
    */
    private Integer industriaId;
    
    /**
    * linea id
    */
    private Integer lineaId;
    
    /**
    * nombre
    */
    private String nombre;

    /** 
     * Default Constructor
     */
    public Marca() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Marca(com.pmarlen.model.beans.Marca jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.industriaId = jpaEntity.getIndustria()!=null?jpaEntity.getIndustria().getId():null; // normalized 
        this.lineaId = jpaEntity.getLinea()!=null?jpaEntity.getLinea().getId():null; // normalized 
        // this.nombre = jpaEntity.getNombre()!=null?jpaEntity.getNombre():null; // bug ?
        this.nombre = jpaEntity.getNombre(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Marca( Integer id ) {
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

    public Integer  getIndustriaId() {
        return this.industriaId;
    }

    public void setIndustriaId(Integer id) {
        this.industriaId = id;
    }

    public Integer  getLineaId() {
        return this.lineaId;
    }

    public void setLineaId(Integer id) {
        this.lineaId = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String v) {
        this.nombre = v;
    }


    public com.pmarlen.model.beans.Marca buildJpaEntity(){
        com.pmarlen.model.beans.Marca jpaEntity = new com.pmarlen.model.beans.Marca();

        jpaEntity.setId( this.getId());
        jpaEntity.setIndustria( this.getIndustriaId()!=null? new com.pmarlen.model.beans.Industria(this.getIndustriaId()):null); // normalized
        jpaEntity.setLinea( this.getLineaId()!=null? new com.pmarlen.model.beans.Linea(this.getLineaId()):null); // normalized
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
        if (!(o instanceof Marca)) {
            return false;
        }

    	Marca other = (Marca ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return industriaId + ", " + lineaId + ", " + nombre;
    }

}
