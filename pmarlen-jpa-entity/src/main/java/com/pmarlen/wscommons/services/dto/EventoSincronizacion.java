
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

// import com.pmarlen.model.beans.EventoSincronizacion;

/**
 * Class for mapping DTO Entity of Table Evento_Sincronizacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class EventoSincronizacion implements java.io.Serializable {
    private static final long serialVersionUID = 1283284357;
    
    /**
    * fecha evento
    */
    private java.util.Date fechaEvento;
    
    /**
    * tipo evento
    */
    private int tipoEvento;
    
    /**
    * afectacion global
    */
    private int afectacionGlobal;
    
    /**
    * sucursal id afectada
    */
    private int sucursalIdAfectada;
    
    /**
    * tabla
    */
    private String tabla;
    
    /**
    * campos llave
    */
    private String camposLlave;
    
    /**
    * valores llave
    */
    private String valoresLlave;

    /** 
     * Default Constructor
     */
    public EventoSincronizacion() {
    }

    /** 
     * JPA Entity Constructor
     */
    public EventoSincronizacion(com.pmarlen.model.beans.EventoSincronizacion jpaEntity) {
        // this.fechaEvento = jpaEntity.getFechaEvento()!=null?jpaEntity.getFechaEvento():null; // bug ?
        this.fechaEvento = jpaEntity.getFechaEvento(); // fixed
        // this.tipoEvento = jpaEntity.getTipoEvento()!=null?jpaEntity.getTipoEvento():null; // bug ?
        this.tipoEvento = jpaEntity.getTipoEvento(); // fixed
        // this.afectacionGlobal = jpaEntity.getAfectacionGlobal()!=null?jpaEntity.getAfectacionGlobal():null; // bug ?
        this.afectacionGlobal = jpaEntity.getAfectacionGlobal(); // fixed
        // this.sucursalIdAfectada = jpaEntity.getSucursalIdAfectada()!=null?jpaEntity.getSucursalIdAfectada():null; // bug ?
        this.sucursalIdAfectada = jpaEntity.getSucursalIdAfectada(); // fixed
        // this.tabla = jpaEntity.getTabla()!=null?jpaEntity.getTabla():null; // bug ?
        this.tabla = jpaEntity.getTabla(); // fixed
        // this.camposLlave = jpaEntity.getCamposLlave()!=null?jpaEntity.getCamposLlave():null; // bug ?
        this.camposLlave = jpaEntity.getCamposLlave(); // fixed
        // this.valoresLlave = jpaEntity.getValoresLlave()!=null?jpaEntity.getValoresLlave():null; // bug ?
        this.valoresLlave = jpaEntity.getValoresLlave(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public EventoSincronizacion( java.util.Date fechaEvento ) {
        this.fechaEvento 	= 	fechaEvento;

    }
    
    /**
     * Getters and Setters
     */
    public java.util.Date getFechaEvento() {
        return this.fechaEvento;
    }

    public void setFechaEvento(java.util.Date v) {
        this.fechaEvento = v;
    }

    public int getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(int v) {
        this.tipoEvento = v;
    }

    public int getAfectacionGlobal() {
        return this.afectacionGlobal;
    }

    public void setAfectacionGlobal(int v) {
        this.afectacionGlobal = v;
    }

    public int getSucursalIdAfectada() {
        return this.sucursalIdAfectada;
    }

    public void setSucursalIdAfectada(int v) {
        this.sucursalIdAfectada = v;
    }

    public String getTabla() {
        return this.tabla;
    }

    public void setTabla(String v) {
        this.tabla = v;
    }

    public String getCamposLlave() {
        return this.camposLlave;
    }

    public void setCamposLlave(String v) {
        this.camposLlave = v;
    }

    public String getValoresLlave() {
        return this.valoresLlave;
    }

    public void setValoresLlave(String v) {
        this.valoresLlave = v;
    }


    public com.pmarlen.model.beans.EventoSincronizacion buildJpaEntity(){
        com.pmarlen.model.beans.EventoSincronizacion jpaEntity = new com.pmarlen.model.beans.EventoSincronizacion();

        jpaEntity.setFechaEvento( this.getFechaEvento());
        jpaEntity.setTipoEvento( this.getTipoEvento());
        jpaEntity.setAfectacionGlobal( this.getAfectacionGlobal());
        jpaEntity.setSucursalIdAfectada( this.getSucursalIdAfectada());
        jpaEntity.setTabla( this.getTabla());
        jpaEntity.setCamposLlave( this.getCamposLlave());
        jpaEntity.setValoresLlave( this.getValoresLlave());

        return jpaEntity;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash = (fechaEvento != null ? fechaEvento.hashCode() : 0 );
        return hash;
    }

    public boolean equals(Object o){

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof EventoSincronizacion)) {
            return false;
        }

    	EventoSincronizacion other = (EventoSincronizacion ) o;
        if ( (this.fechaEvento == null && other.fechaEvento != null) || (this.fechaEvento != null && !this.fechaEvento.equals(other.fechaEvento))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.EventoSincronizacion[fechaEvento = "+fechaEvento+ "]";
    }

}
