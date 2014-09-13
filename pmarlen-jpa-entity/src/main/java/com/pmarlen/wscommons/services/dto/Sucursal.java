
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
 * @date 2014/09/11 12:55
 */

public class Sucursal implements java.io.Serializable {
    private static final long serialVersionUID = 1973769562;
    
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
        // this.id = jpaEntity.getId()!=null?jpaEntity.getId():null; // bug ?
        this.id = jpaEntity.getId(); // fixed
        this.idPadre = jpaEntity.getIdPadre()!=null?jpaEntity.getIdPadre().getId():null; // custom
        // this.nombre = jpaEntity.getNombre()!=null?jpaEntity.getNombre():null; // bug ?
        this.nombre = jpaEntity.getNombre(); // fixed
        // this.direccion = jpaEntity.getDireccion()!=null?jpaEntity.getDireccion():null; // bug ?
        this.direccion = jpaEntity.getDireccion(); // fixed
        // this.telefonos = jpaEntity.getTelefonos()!=null?jpaEntity.getTelefonos():null; // bug ?
        this.telefonos = jpaEntity.getTelefonos(); // fixed
        // this.usuarioSicofi = jpaEntity.getUsuarioSicofi()!=null?jpaEntity.getUsuarioSicofi():null; // bug ?
        this.usuarioSicofi = jpaEntity.getUsuarioSicofi(); // fixed
        // this.passwordSicofi = jpaEntity.getPasswordSicofi()!=null?jpaEntity.getPasswordSicofi():null; // bug ?
        this.passwordSicofi = jpaEntity.getPasswordSicofi(); // fixed
        // this.serieSicofi = jpaEntity.getSerieSicofi()!=null?jpaEntity.getSerieSicofi():null; // bug ?
        this.serieSicofi = jpaEntity.getSerieSicofi(); // fixed
        // this.comentarios = jpaEntity.getComentarios()!=null?jpaEntity.getComentarios():null; // bug ?
        this.comentarios = jpaEntity.getComentarios(); // fixed
        // this.descuentoMayoreoHabilitado = jpaEntity.getDescuentoMayoreoHabilitado()!=null?jpaEntity.getDescuentoMayoreoHabilitado():null; // bug ?
        this.descuentoMayoreoHabilitado = jpaEntity.getDescuentoMayoreoHabilitado(); // fixed
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
