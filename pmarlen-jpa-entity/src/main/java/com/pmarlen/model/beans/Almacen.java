
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
 * Class for mapping JPA Entity of Table Almacen.
 * m2m
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */



@Entity
@Table(name = "ALMACEN")
public class Almacen implements java.io.Serializable {
    private static final long serialVersionUID = 1260258275;
    
    /**
    * id
    */
    @Id
    @Basic(optional = false)
    @Column(name = "ID"   )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * sucursal id
    */
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursal;
    
    /**
    * tipo almacen
    */
    @Basic(optional = false)
    @Column(name = "TIPO_ALMACEN"   )
    private int tipoAlmacen;
    // bug , must refering Movimiento_operativo_almacen.Almacen_destino => almacenDestino, normalized ? false
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenDestino")
    private Collection<MovimientoOperativoAlmacen> movimientoOperativoAlmacenToAlmacenOrigenCollection;
    
    // bug , must refering Movimiento_operativo_almacen.Almacen_destino => almacenDestino, normalized ? false
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenDestino")
    private Collection<MovimientoOperativoAlmacen> movimientoOperativoAlmacenToAlmacenDestinoCollection;
    
    // bug , must refering Movimiento_Historico_Producto.Almacen_id => almacenId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<MovimientoHistoricoProducto> movimientoHistoricoProductoCollection;
    
    // bug , must refering Entrada_almacen.Almacen_id => almacenId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<EntradaAlmacen> entradaAlmacenCollection;
    
    // bug , must refering Almacen_Producto.Almacen_id => almacenId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<AlmacenProducto> almacenProductoCollection;
    
    // bug , must refering Pedido_Venta_Detalle.Almacen_id => almacenId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<PedidoVentaDetalle> pedidoVentaDetalleCollection;
    

    /** 
     * Default Constructor
     */
    public Almacen() {
    }

    /** 
     * lazy Constructor just with IDs
     */
    public Almacen( Integer id ) {
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

    public Sucursal getSucursal () {
        return this.sucursal;
    }

    public void setSucursal(Sucursal v) {
        this.sucursal = v;
    }

    public int getTipoAlmacen() {
        return this.tipoAlmacen;
    }

    public void setTipoAlmacen(int v) {
        this.tipoAlmacen = v;
    }

    
    public Collection<MovimientoOperativoAlmacen> getMovimientoOperativoAlmacenToAlmacenOrigenCollection() {
        return this.movimientoOperativoAlmacenToAlmacenOrigenCollection;
    }
    
    
    public void setMovimientoOperativoAlmacenToAlmacenOrigenCollection(Collection<MovimientoOperativoAlmacen>  v) {
        this.movimientoOperativoAlmacenToAlmacenOrigenCollection = v;
    }
    
    public Collection<MovimientoOperativoAlmacen> getMovimientoOperativoAlmacenToAlmacenDestinoCollection() {
        return this.movimientoOperativoAlmacenToAlmacenDestinoCollection;
    }
    
    
    public void setMovimientoOperativoAlmacenToAlmacenDestinoCollection(Collection<MovimientoOperativoAlmacen>  v) {
        this.movimientoOperativoAlmacenToAlmacenDestinoCollection = v;
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
    
    public Collection<AlmacenProducto> getAlmacenProductoCollection() {
        return this.almacenProductoCollection;
    }
    
    
    public void setAlmacenProductoCollection(Collection<AlmacenProducto>  v) {
        this.almacenProductoCollection = v;
    }
    
    public Collection<PedidoVentaDetalle> getPedidoVentaDetalleCollection() {
        return this.pedidoVentaDetalleCollection;
    }
    
    
    public void setPedidoVentaDetalleCollection(Collection<PedidoVentaDetalle>  v) {
        this.pedidoVentaDetalleCollection = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = (id != null ? id.hashCode() : 0 );
        return hash;
    }

    public boolean equals(Object o){

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof Almacen)) {
            return false;
        }

    	Almacen other = (Almacen ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.model.beans.Almacen[id = "+id+ "]";
    }

}
