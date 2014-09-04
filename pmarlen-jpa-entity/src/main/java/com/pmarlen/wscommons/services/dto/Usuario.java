
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

// import com.pmarlen.model.beans.Usuario;

/**
 * Class for mapping DTO Entity of Table Usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1410508107;
    
    /**
    * id
    */
    private String id;
    
    /**
    * habilitado
    */
    private int habilitado;
    
    /**
    * nombre completo
    */
    private String nombreCompleto;
    
    /**
    * password
    */
    private String password;
    
    /**
    * email
    */
    private String email;
    
    /**
    * sucursal id
    */
    private Integer sucursalId;

    /** 
     * Default Constructor
     */
    public Usuario() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Usuario(com.pmarlen.model.beans.Usuario jpaEntity) {
        this.id = jpaEntity.getId();
        this.habilitado = jpaEntity.getHabilitado();
        this.nombreCompleto = jpaEntity.getNombreCompleto();
        this.password = jpaEntity.getPassword();
        this.email = jpaEntity.getEmail();
        this.sucursalId = jpaEntity.getSucursal().getId(); // normalized 
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Usuario( String id ) {
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

    public int getHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(int v) {
        this.habilitado = v;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String v) {
        this.nombreCompleto = v;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String v) {
        this.password = v;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String v) {
        this.email = v;
    }

    public Integer  getSucursalId() {
        return this.sucursalId;
    }

    public void setSucursalId(Integer id) {
        this.sucursalId = id;
    }


    public com.pmarlen.model.beans.Usuario buildJpaEntity(){
        com.pmarlen.model.beans.Usuario jpaEntity = new com.pmarlen.model.beans.Usuario();

        jpaEntity.setId( this.getId());
        jpaEntity.setHabilitado( this.getHabilitado());
        jpaEntity.setNombreCompleto( this.getNombreCompleto());
        jpaEntity.setPassword( this.getPassword());
        jpaEntity.setEmail( this.getEmail());
        jpaEntity.setSucursal( new com.pmarlen.model.beans.Sucursal(this.getSucursalId())); // normalized

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
        if (!(o instanceof Usuario)) {
            return false;
        }

    	Usuario other = (Usuario ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }

}
