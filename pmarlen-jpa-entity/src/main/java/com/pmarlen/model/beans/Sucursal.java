
package com.pmarlen.model.beans;

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
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class for mapping JPA Entity of Table Sucursal.
 * m2m
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */



@Entity
@Table(name = "SUCURSAL")
public class Sucursal implements java.io.Serializable {
    private static final long serialVersionUID = 1717922155;
    
    /**
    * id
    */
    @Id
    @Basic(optional = false)
    @Column(name = "ID"   )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * id padre
    */
    @JoinColumn(name = "ID_PADRE" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Sucursal idPadre;
    
    /**
    * nombre
    */
    @Basic(optional = false)
    @Column(name = "NOMBRE" , length=128  )
    private String nombre;
    
    /**
    * direccion
    */
    @Basic(optional = true)
    @Column(name = "DIRECCION" , length=255  )
    private String direccion;
    
    /**
    * telefonos
    */
    @Basic(optional = true)
    @Column(name = "TELEFONOS" , length=128  )
    private String telefonos;
    
    /**
    * usuario sicofi
    */
    @Basic(optional = true)
    @Column(name = "USUARIO_SICOFI" , length=64  )
    private String usuarioSicofi;
    
    /**
    * password sicofi
    */
    @Basic(optional = true)
    @Column(name = "PASSWORD_SICOFI" , length=64  )
    private String passwordSicofi;
    
    /**
    * serie sicofi
    */
    @Basic(optional = true)
    @Column(name = "SERIE_SICOFI" , length=4  )
    private String serieSicofi;
    
    /**
    * comentarios
    */
    @Basic(optional = true)
    @Column(name = "COMENTARIOS" , length=255  )
    private String comentarios;
    
    /**
    * descuento mayoreo habilitado
    */
    @Basic(optional = true)
    @Column(name = "DESCUENTO_MAYOREO_HABILITADO"   )
    private Integer descuentoMayoreoHabilitado;
    // bug , must refering Almacen.Sucursal_id => sucursalId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private Collection<Almacen> almacenCollection;
    
    // bug , must refering Usuario.Sucursal_id => sucursalId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private Collection<Usuario> usuarioCollection;
    
    // bug , must refering Sucursal.id_padre => idPadre, normalized ? false
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPadre")
    private Collection<Sucursal> sucursalCollection;
    

    /** 
     * Default Constructor
     */
    public Sucursal() {
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

    public Sucursal getIdPadre () {
        return this.idPadre;
    }

    public void setIdPadre(Sucursal v) {
        this.idPadre = v;
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

    
    public Collection<Almacen> getAlmacenCollection() {
        return this.almacenCollection;
    }
    
    
    public void setAlmacenCollection(Collection<Almacen>  v) {
        this.almacenCollection = v;
    }
    
    public Collection<Usuario> getUsuarioCollection() {
        return this.usuarioCollection;
    }
    
    
    public void setUsuarioCollection(Collection<Usuario>  v) {
        this.usuarioCollection = v;
    }
    
    public Collection<Sucursal> getSucursalCollection() {
        return this.sucursalCollection;
    }
    
    
    public void setSucursalCollection(Collection<Sucursal>  v) {
        this.sucursalCollection = v;
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
