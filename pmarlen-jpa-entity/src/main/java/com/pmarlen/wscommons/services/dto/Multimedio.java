
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

// import com.pmarlen.model.beans.Multimedio;

/**
 * Class for mapping DTO Entity of Table Multimedio.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class Multimedio implements java.io.Serializable {
    private static final long serialVersionUID = 1809752898;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * mime type
    */
    private String mimeType;
    
    /**
    * ruta contenido
    */
    private String rutaContenido;
    
    /**
    * size bytes
    */
    private int sizeBytes;
    
    /**
    * nombre archivo
    */
    private String nombreArchivo;

    /** 
     * Default Constructor
     */
    public Multimedio() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Multimedio(com.pmarlen.model.beans.Multimedio jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.mimeType = jpaEntity.getMimeType()!=null?jpaEntity.getMimeType():null; // bug ?
        this.mimeType = jpaEntity.getMimeType(); // fixed
        // this.rutaContenido = jpaEntity.getRutaContenido()!=null?jpaEntity.getRutaContenido():null; // bug ?
        this.rutaContenido = jpaEntity.getRutaContenido(); // fixed
        // this.sizeBytes = jpaEntity.getSizeBytes()!=null?jpaEntity.getSizeBytes():null; // bug ?
        this.sizeBytes = jpaEntity.getSizeBytes(); // fixed
        // this.nombreArchivo = jpaEntity.getNombreArchivo()!=null?jpaEntity.getNombreArchivo():null; // bug ?
        this.nombreArchivo = jpaEntity.getNombreArchivo(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Multimedio( Integer id ) {
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

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String v) {
        this.mimeType = v;
    }

    public String getRutaContenido() {
        return this.rutaContenido;
    }

    public void setRutaContenido(String v) {
        this.rutaContenido = v;
    }

    public int getSizeBytes() {
        return this.sizeBytes;
    }

    public void setSizeBytes(int v) {
        this.sizeBytes = v;
    }

    public String getNombreArchivo() {
        return this.nombreArchivo;
    }

    public void setNombreArchivo(String v) {
        this.nombreArchivo = v;
    }


    public com.pmarlen.model.beans.Multimedio buildJpaEntity(){
        com.pmarlen.model.beans.Multimedio jpaEntity = new com.pmarlen.model.beans.Multimedio();

        jpaEntity.setId( this.getId());
        jpaEntity.setMimeType( this.getMimeType());
        jpaEntity.setRutaContenido( this.getRutaContenido());
        jpaEntity.setSizeBytes( this.getSizeBytes());
        jpaEntity.setNombreArchivo( this.getNombreArchivo());

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
        if (!(o instanceof Multimedio)) {
            return false;
        }

    	Multimedio other = (Multimedio ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombreArchivo;
    }

}
