
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

// import com.pmarlen.model.beans.CfdVenta;

/**
 * Class for mapping DTO Entity of Table CFD_Venta.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class CfdVenta implements java.io.Serializable {
    private static final long serialVersionUID = 2061354276;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * ultima actualizacion
    */
    private java.util.Date ultimaActualizacion;
    
    /**
    * contenido original xml
    */
    private byte[] contenidoOriginalXml;
    
    /**
    * calling error result
    */
    private String callingErrorResult;

    /** 
     * Default Constructor
     */
    public CfdVenta() {
    }

    /** 
     * JPA Entity Constructor
     */
    public CfdVenta(com.pmarlen.model.beans.CfdVenta jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.ultimaActualizacion = jpaEntity.getUltimaActualizacion()!=null?jpaEntity.getUltimaActualizacion():null; // bug ?
        this.ultimaActualizacion = jpaEntity.getUltimaActualizacion(); // fixed
        // this.contenidoOriginalXml = jpaEntity.getContenidoOriginalXml()!=null?jpaEntity.getContenidoOriginalXml():null; // bug ?
        this.contenidoOriginalXml = jpaEntity.getContenidoOriginalXml(); // fixed
        // this.callingErrorResult = jpaEntity.getCallingErrorResult()!=null?jpaEntity.getCallingErrorResult():null; // bug ?
        this.callingErrorResult = jpaEntity.getCallingErrorResult(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public CfdVenta( Integer id ) {
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

    public java.util.Date getUltimaActualizacion() {
        return this.ultimaActualizacion;
    }

    public void setUltimaActualizacion(java.util.Date v) {
        this.ultimaActualizacion = v;
    }

    public byte[] getContenidoOriginalXml() {
        return this.contenidoOriginalXml;
    }

    public void setContenidoOriginalXml(byte[] v) {
        this.contenidoOriginalXml = v;
    }

    public String getCallingErrorResult() {
        return this.callingErrorResult;
    }

    public void setCallingErrorResult(String v) {
        this.callingErrorResult = v;
    }


    public com.pmarlen.model.beans.CfdVenta buildJpaEntity(){
        com.pmarlen.model.beans.CfdVenta jpaEntity = new com.pmarlen.model.beans.CfdVenta();

        jpaEntity.setId( this.getId());
        jpaEntity.setUltimaActualizacion( this.getUltimaActualizacion());
        jpaEntity.setContenidoOriginalXml( this.getContenidoOriginalXml());
        jpaEntity.setCallingErrorResult( this.getCallingErrorResult());

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
        if (!(o instanceof CfdVenta)) {
            return false;
        }

    	CfdVenta other = (CfdVenta ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.CfdVenta[id = "+id+ "]";
    }

}
