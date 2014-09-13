
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
 * Class for mapping JPA Entity of Table Usuario.
 * m2m
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */



@Entity
@Table(name = "USUARIO")
public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1366415098;
    
    /**
    * email
    */
    @Id
    @Basic(optional = false)
    @Column(name = "EMAIL" , length=64  )
    private String email;
    
    /**
    * habilitado
    */
    @Basic(optional = false)
    @Column(name = "HABILITADO"   )
    private int habilitado;
    
    /**
    * nombre completo
    */
    @Basic(optional = false)
    @Column(name = "NOMBRE_COMPLETO" , length=128  )
    private String nombreCompleto;
    
    /**
    * password
    */
    @Basic(optional = false)
    @Column(name = "PASSWORD" , length=64  )
    private String password;
    
    /**
    * sucursal id
    */
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Sucursal sucursal;
    // bug , must refering Movimiento_operativo_almacen.Usuario_email => usuarioEmail, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<MovimientoOperativoAlmacen> movimientoOperativoAlmacenCollection;
    
    // bug , must refering Movimiento_Historico_Producto.Usuario_email => usuarioEmail, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<MovimientoHistoricoProducto> movimientoHistoricoProductoCollection;
    
    // bug , must refering Entrada_almacen.Usuario_email => usuarioEmail, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<EntradaAlmacen> entradaAlmacenCollection;
    
    // bug , must refering Pedido_Venta.Usuario_email => usuarioEmail, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<PedidoVenta> pedidoVentaCollection;
    
    
    @JoinTable(name               = "USUARIO_PERFIL",
               joinColumns        = {@JoinColumn(name = "EMAIL", referencedColumnName ="EMAIL")},
               inverseJoinColumns = {@JoinColumn(name = "PERFIL_ID", referencedColumnName ="ID")}
               )
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Perfil> perfilCollection;
    

    /** 
     * Default Constructor
     */
    public Usuario() {
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

    public Sucursal getSucursal () {
        return this.sucursal;
    }

    public void setSucursal(Sucursal v) {
        this.sucursal = v;
    }

    
    public Collection<MovimientoOperativoAlmacen> getMovimientoOperativoAlmacenCollection() {
        return this.movimientoOperativoAlmacenCollection;
    }
    
    
    public void setMovimientoOperativoAlmacenCollection(Collection<MovimientoOperativoAlmacen>  v) {
        this.movimientoOperativoAlmacenCollection = v;
    }
    
    public Collection<MovimientoHistoricoProducto> getMovimientoHistoricoProductoCollection() {
        return this.movimientoHistoricoProductoCollection;
    }
    
    
    public void setMovimientoHistoricoProductoCollection(Collection<MovimientoHistoricoProducto>  v) {
        this.movimientoHistoricoProductoCollection = v;
    }
    
    public Collection<EntradaAlmacen> getEntradaAlmacenCollection() {
        return this.entradaAlmacenCollection;
    }
    
    
    public void setEntradaAlmacenCollection(Collection<EntradaAlmacen>  v) {
        this.entradaAlmacenCollection = v;
    }
    
    public Collection<PedidoVenta> getPedidoVentaCollection() {
        return this.pedidoVentaCollection;
    }
    
    
    public void setPedidoVentaCollection(Collection<PedidoVenta>  v) {
        this.pedidoVentaCollection = v;
    }
    // Getter and Setters @ManyToMany Collection<Perfil>
    
    public Collection<Perfil> getPerfilCollection() {
        return this.perfilCollection;
    }
    
    
    public void setPerfilCollection(Collection<Perfil>  v) {
        this.perfilCollection = v;
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
