
package com.pmarlen.wscommons.services.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// import com.pmarlen.model.beans.Usuario;

/**
 * Class for mapping DTO Entity of Table Usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */

public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1366415098;
    
    /**
    * email
    */
    private String email;
    
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
    * sucursal id
    */
    private Integer sucursalId;
	
	private List<Perfil> perfilList;

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}
	
    /** 
     * Default Constructor
     */
    public Usuario() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Usuario(com.pmarlen.model.beans.Usuario jpaEntity) {
        // this.email = jpaEntity.getEmail()!=null?jpaEntity.getEmail():null; // bug ?
        this.email = jpaEntity.getEmail(); // fixed
        // this.habilitado = jpaEntity.getHabilitado()!=null?jpaEntity.getHabilitado():null; // bug ?
        this.habilitado = jpaEntity.getHabilitado(); // fixed
        // this.nombreCompleto = jpaEntity.getNombreCompleto()!=null?jpaEntity.getNombreCompleto():null; // bug ?
        this.nombreCompleto = jpaEntity.getNombreCompleto(); // fixed
        // this.password = jpaEntity.getPassword()!=null?jpaEntity.getPassword():null; // bug ?
        this.password = jpaEntity.getPassword(); // fixed
        this.sucursalId = jpaEntity.getSucursal()!=null?jpaEntity.getSucursal().getId():null; // normalized 
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Usuario( String email ) {
        this.email 	= 	email;

    }
    
    /**
     * Getters and Setters
     */
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String v) {
        this.email = v;
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

    public Integer  getSucursalId() {
        return this.sucursalId;
    }

    public void setSucursalId(Integer id) {
        this.sucursalId = id;
    }


    public com.pmarlen.model.beans.Usuario buildJpaEntity(){
        com.pmarlen.model.beans.Usuario jpaEntity = new com.pmarlen.model.beans.Usuario();

        jpaEntity.setEmail( this.getEmail());
        jpaEntity.setHabilitado( this.getHabilitado());
        jpaEntity.setNombreCompleto( this.getNombreCompleto());
        jpaEntity.setPassword( this.getPassword());
        jpaEntity.setSucursal( this.getSucursalId()!=null? new com.pmarlen.model.beans.Sucursal(this.getSucursalId()):null); // normalized

        return jpaEntity;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash = (email != null ? email.hashCode() : 0 );
        return hash;
    }

    public boolean equals(Object o){

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof Usuario)) {
            return false;
        }

    	Usuario other = (Usuario ) o;
        if ( (this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }

}
