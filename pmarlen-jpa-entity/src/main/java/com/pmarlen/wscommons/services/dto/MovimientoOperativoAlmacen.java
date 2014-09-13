
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

// import com.pmarlen.model.beans.MovimientoOperativoAlmacen;

/**
 * Class for mapping DTO Entity of Table Movimiento_operativo_almacen.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class MovimientoOperativoAlmacen implements java.io.Serializable {
    private static final long serialVersionUID = 1879240281;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * motivo
    */
    private String motivo;
    
    /**
    * usuario email
    */
    private String usuarioEmail;
    
    /**
    * fecha inicio
    */
    private java.util.Date fechaInicio;
    
    /**
    * almacen origen
    */
    private Integer almacenOrigen;
    
    /**
    * almacen destino
    */
    private Integer almacenDestino;
    
    /**
    * tipo movimiento id
    */
    private int tipoMovimientoId;
    
    /**
    * fecha confirmacion
    */
    private Integer fechaConfirmacion;

    /** 
     * Default Constructor
     */
    public MovimientoOperativoAlmacen() {
    }

    /** 
     * JPA Entity Constructor
     */
    public MovimientoOperativoAlmacen(com.pmarlen.model.beans.MovimientoOperativoAlmacen jpaEntity) {
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        // this.motivo = jpaEntity.getMotivo()!=null?jpaEntity.getMotivo():null; // bug ?
        this.motivo = jpaEntity.getMotivo(); // fixed
        this.usuarioEmail = jpaEntity.getUsuario()!=null?jpaEntity.getUsuario().getEmail():null; // normalized 
        // this.fechaInicio = jpaEntity.getFechaInicio()!=null?jpaEntity.getFechaInicio():null; // bug ?
        this.fechaInicio = jpaEntity.getFechaInicio(); // fixed
        this.almacenOrigen = jpaEntity.getAlmacenOrigen()!=null?jpaEntity.getAlmacenOrigen().getId():null; // custom
        this.almacenDestino = jpaEntity.getAlmacenDestino()!=null?jpaEntity.getAlmacenDestino().getId():null; // custom
        // this.tipoMovimientoId = jpaEntity.getTipoMovimientoId()!=null?jpaEntity.getTipoMovimientoId():null; // bug ?
        this.tipoMovimientoId = jpaEntity.getTipoMovimientoId(); // fixed
        // this.fechaConfirmacion = jpaEntity.getFechaConfirmacion()!=null?jpaEntity.getFechaConfirmacion():null; // bug ?
        this.fechaConfirmacion = jpaEntity.getFechaConfirmacion(); // fixed
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public MovimientoOperativoAlmacen( Integer id ) {
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

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String v) {
        this.motivo = v;
    }

    public String  getUsuarioEmail() {
        return this.usuarioEmail;
    }

    public void setUsuarioEmail(String id) {
        this.usuarioEmail = id;
    }

    public java.util.Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(java.util.Date v) {
        this.fechaInicio = v;
    }

    public Integer  getAlmacenOrigen() {
        return this.almacenOrigen;
    }

    public void setAlmacenOrigen(Integer id) {
        this.almacenOrigen = id;
    }

    public Integer  getAlmacenDestino() {
        return this.almacenDestino;
    }

    public void setAlmacenDestino(Integer id) {
        this.almacenDestino = id;
    }

    public int getTipoMovimientoId() {
        return this.tipoMovimientoId;
    }

    public void setTipoMovimientoId(int v) {
        this.tipoMovimientoId = v;
    }

    public Integer getFechaConfirmacion() {
        return this.fechaConfirmacion;
    }

    public void setFechaConfirmacion(Integer v) {
        this.fechaConfirmacion = v;
    }


    public com.pmarlen.model.beans.MovimientoOperativoAlmacen buildJpaEntity(){
        com.pmarlen.model.beans.MovimientoOperativoAlmacen jpaEntity = new com.pmarlen.model.beans.MovimientoOperativoAlmacen();

        jpaEntity.setId( this.getId());
        jpaEntity.setMotivo( this.getMotivo());
        jpaEntity.setUsuario( this.getUsuarioEmail()!=null? new com.pmarlen.model.beans.Usuario(this.getUsuarioEmail()):null); // normalized
        jpaEntity.setFechaInicio( this.getFechaInicio());
        jpaEntity.setAlmacenOrigen( new com.pmarlen.model.beans.Almacen(this.getAlmacenOrigen())); // custom
        jpaEntity.setAlmacenDestino( new com.pmarlen.model.beans.Almacen(this.getAlmacenDestino())); // custom
        jpaEntity.setTipoMovimientoId( this.getTipoMovimientoId());
        jpaEntity.setFechaConfirmacion( this.getFechaConfirmacion());

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
        if (!(o instanceof MovimientoOperativoAlmacen)) {
            return false;
        }

    	MovimientoOperativoAlmacen other = (MovimientoOperativoAlmacen ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.wscommons.services.dto.MovimientoOperativoAlmacen[id = "+id+ "]";
    }

}
