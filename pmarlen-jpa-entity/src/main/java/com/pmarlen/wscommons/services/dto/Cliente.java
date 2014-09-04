
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

// import com.pmarlen.model.beans.Cliente;

/**
 * Class for mapping DTO Entity of Table Cliente.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class Cliente implements java.io.Serializable {
    private static final long serialVersionUID = 359746701;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * rfc
    */
    private String rfc;
    
    /**
    * razon social
    */
    private String razonSocial;
    
    /**
    * nombre establecimiento
    */
    private String nombreEstablecimiento;
    
    /**
    * contacto
    */
    private String contacto;
    
    /**
    * telefonos
    */
    private String telefonos;
    
    /**
    * email
    */
    private String email;
    
    /**
    * observaciones
    */
    private String observaciones;
    
    /**
    * direccion
    */
    private String direccion;

    /** 
     * Default Constructor
     */
    public Cliente() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Cliente(com.pmarlen.model.beans.Cliente jpaEntity) {
        this.id = jpaEntity.getId();
        this.rfc = jpaEntity.getRfc();
        this.razonSocial = jpaEntity.getRazonSocial();
        this.nombreEstablecimiento = jpaEntity.getNombreEstablecimiento();
        this.contacto = jpaEntity.getContacto();
        this.telefonos = jpaEntity.getTelefonos();
        this.email = jpaEntity.getEmail();
        this.observaciones = jpaEntity.getObservaciones();
        this.direccion = jpaEntity.getDireccion();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Cliente( Integer id ) {
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

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String v) {
        this.rfc = v;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String v) {
        this.razonSocial = v;
    }

    public String getNombreEstablecimiento() {
        return this.nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String v) {
        this.nombreEstablecimiento = v;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String v) {
        this.contacto = v;
    }

    public String getTelefonos() {
        return this.telefonos;
    }

    public void setTelefonos(String v) {
        this.telefonos = v;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String v) {
        this.email = v;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String v) {
        this.observaciones = v;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String v) {
        this.direccion = v;
    }


    public com.pmarlen.model.beans.Cliente buildJpaEntity(){
        com.pmarlen.model.beans.Cliente jpaEntity = new com.pmarlen.model.beans.Cliente();

        jpaEntity.setId( this.getId());
        jpaEntity.setRfc( this.getRfc());
        jpaEntity.setRazonSocial( this.getRazonSocial());
        jpaEntity.setNombreEstablecimiento( this.getNombreEstablecimiento());
        jpaEntity.setContacto( this.getContacto());
        jpaEntity.setTelefonos( this.getTelefonos());
        jpaEntity.setEmail( this.getEmail());
        jpaEntity.setObservaciones( this.getObservaciones());
        jpaEntity.setDireccion( this.getDireccion());

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
        if (!(o instanceof Cliente)) {
            return false;
        }

    	Cliente other = (Cliente ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return razonSocial;
    }

}
