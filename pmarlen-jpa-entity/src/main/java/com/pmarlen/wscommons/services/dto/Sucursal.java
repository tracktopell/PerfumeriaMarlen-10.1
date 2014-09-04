
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

// import com.pmarlen.model.beans.Sucursal;

/**
 * Class for mapping DTO Entity of Table Sucursal.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */

public class Sucursal implements java.io.Serializable {
    private static final long serialVersionUID = 1717922155;
    
    /**
    * id
    */
    private Integer id;
    
    /**
    * id padre
    */
    private Integer idPadre;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * direccion
    */
    private String direccion;
    
    /**
    * telefonos
    */
    private String telefonos;
    
    /**
    * usuario sicofi
    */
    private String usuarioSicofi;
    
    /**
    * password sicofi
    */
    private String passwordSicofi;
    
    /**
    * serie sicofi
    */
    private String serieSicofi;
    
    /**
    * comentarios
    */
    private String comentarios;
    
    /**
    * descuento mayoreo habilitado
    */
    private Integer descuentoMayoreoHabilitado;

    /** 
     * Default Constructor
     */
    public Sucursal() {
    }

    /** 
     * JPA Entity Constructor
     */
    public Sucursal(com.pmarlen.model.beans.Sucursal jpaEntity) {
        this.id = jpaEntity.getId();
        this.idPadre = jpaEntity.getIdPadre().getId(); // custom
        this.nombre = jpaEntity.getNombre();
        this.direccion = jpaEntity.getDireccion();
        this.telefonos = jpaEntity.getTelefonos();
        this.usuarioSicofi = jpaEntity.getUsuarioSicofi();
        this.passwordSicofi = jpaEntity.getPasswordSicofi();
        this.serieSicofi = jpaEntity.getSerieSicofi();
        this.comentarios = jpaEntity.getComentarios();
        this.descuentoMayoreoHabilitado = jpaEntity.getDescuentoMayoreoHabilitado();
    }
	
    /** 
     * lazy Constructor just with IDs
     */
    public Sucursal( Integer id ) {
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

    public Integer  getIdPadre() {
        return this.idPadre;
    }

    public void setIdPadre(Integer id) {
        this.idPadre = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String v) {
        this.nombre = v;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String v) {
        this.direccion = v;
    }

    public String getTelefonos() {
        return this.telefonos;
    }

    public void setTelefonos(String v) {
        this.telefonos = v;
    }

    public String getUsuarioSicofi() {
        return this.usuarioSicofi;
    }

    public void setUsuarioSicofi(String v) {
        this.usuarioSicofi = v;
    }

    public String getPasswordSicofi() {
        return this.passwordSicofi;
    }

    public void setPasswordSicofi(String v) {
        this.passwordSicofi = v;
    }

    public String getSerieSicofi() {
        return this.serieSicofi;
    }

    public void setSerieSicofi(String v) {
        this.serieSicofi = v;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String v) {
        this.comentarios = v;
    }

    public Integer getDescuentoMayoreoHabilitado() {
        return this.descuentoMayoreoHabilitado;
    }

    public void setDescuentoMayoreoHabilitado(Integer v) {
        this.descuentoMayoreoHabilitado = v;
    }


    public com.pmarlen.model.beans.Sucursal buildJpaEntity(){
        com.pmarlen.model.beans.Sucursal jpaEntity = new com.pmarlen.model.beans.Sucursal();

        jpaEntity.setId( this.getId());
        jpaEntity.setIdPadre( new com.pmarlen.model.beans.Sucursal(this.getIdPadre())); // custom
        jpaEntity.setNombre( this.getNombre());
        jpaEntity.setDireccion( this.getDireccion());
        jpaEntity.setTelefonos( this.getTelefonos());
        jpaEntity.setUsuarioSicofi( this.getUsuarioSicofi());
        jpaEntity.setPasswordSicofi( this.getPasswordSicofi());
        jpaEntity.setSerieSicofi( this.getSerieSicofi());
        jpaEntity.setComentarios( this.getComentarios());
        jpaEntity.setDescuentoMayoreoHabilitado( this.getDescuentoMayoreoHabilitado());

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
        if (!(o instanceof Sucursal)) {
            return false;
        }

    	Sucursal other = (Sucursal ) o;
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
