
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
 * Class for mapping JPA Entity of Table Producto.
 * m2m
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/09/11 12:55
 */



@Entity
@Table(name = "PRODUCTO")
public class Producto implements java.io.Serializable {
    private static final long serialVersionUID = 83389031;
    
    /**
    * id
    */
    @Id
    @Basic(optional = false)
    @Column(name = "ID"   )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * codigo barras
    */
    @Basic(optional = false)
    @Column(name = "CODIGO_BARRAS" , length=64  )
    private String codigoBarras;
    
    /**
    * marca id
    */
    @JoinColumn(name = "MARCA_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Marca marca;
    
    /**
    * nombre
    */
    @Basic(optional = false)
    @Column(name = "NOMBRE" , length=255  )
    private String nombre;
    
    /**
    * presentacion
    */
    @Basic(optional = false)
    @Column(name = "PRESENTACION" , length=255  )
    private String presentacion;
    
    /**
    * unidades por caja
    */
    @Basic(optional = false)
    @Column(name = "UNIDADES_POR_CAJA"   )
    private int unidadesPorCaja;
    
    /**
    * unidad medida
    */
    @Basic(optional = false)
    @Column(name = "UNIDAD_MEDIDA" , length=8  )
    private String unidadMedida;
    
    /**
    * costo
    */
    @Basic(optional = false)
    @Column(name = "COSTO"   )
    private double costo;
    
    /**
    * costo venta
    */
    @Basic(optional = false)
    @Column(name = "COSTO_VENTA"   )
    private double costoVenta;
    
    /**
    * contenido
    */
    @Basic(optional = true)
    @Column(name = "CONTENIDO" , length=16  )
    private String contenido;
    
    /**
    * abrebiatura
    */
    @Basic(optional = true)
    @Column(name = "ABREBIATURA" , length=128  )
    private String abrebiatura;
    
    /**
    * precio venta tmp
    */
    @Basic(optional = true)
    @Column(name = "PRECIO_VENTA_TMP"   )
    private Double precioVentaTmp;
    
    /**
    * cantidad actual tmp
    */
    @Basic(optional = true)
    @Column(name = "CANTIDAD_ACTUAL_TMP"   )
    private Integer cantidadActualTmp;
    // bug , must refering Movimiento_Historico_Producto.Producto_id => productoId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<MovimientoHistoricoProducto> movimientoHistoricoProductoCollection;
    
    // bug , must refering Movimiento_operativo_almacen_Detalle.Producto_id => productoId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<MovimientoOperativoAlmacenDetalle> movimientoOperativoAlmacenDetalleCollection;
    
    // bug , must refering Almacen_Producto.Producto_id => productoId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<AlmacenProducto> almacenProductoCollection;
    
    // bug , must refering Pedido_Venta_Detalle.Producto_id => productoId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<PedidoVentaDetalle> pedidoVentaDetalleCollection;
    
    // bug , must refering Entrada_Almacen_Detalle.Producto_id => productoId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<EntradaAlmacenDetalle> entradaAlmacenDetalleCollection;
    
    
    @ManyToMany(mappedBy = "productoCollection")
    private Collection<Multimedio> multimedioCollection;
    

    /** 
     * Default Constructor
     */
    public Producto() {
    }

    /** 
     * lazy Constructor just with IDs
     */
    public Producto( Integer id ) {
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

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public void setCodigoBarras(String v) {
        this.codigoBarras = v;
    }

    public Marca getMarca () {
        return this.marca;
    }

    public void setMarca(Marca v) {
        this.marca = v;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String v) {
        this.nombre = v;
    }

    public String getPresentacion() {
        return this.presentacion;
    }

    public void setPresentacion(String v) {
        this.presentacion = v;
    }

    public int getUnidadesPorCaja() {
        return this.unidadesPorCaja;
    }

    public void setUnidadesPorCaja(int v) {
        this.unidadesPorCaja = v;
    }

    public String getUnidadMedida() {
        return this.unidadMedida;
    }

    public void setUnidadMedida(String v) {
        this.unidadMedida = v;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double v) {
        this.costo = v;
    }

    public double getCostoVenta() {
        return this.costoVenta;
    }

    public void setCostoVenta(double v) {
        this.costoVenta = v;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String v) {
        this.contenido = v;
    }

    public String getAbrebiatura() {
        return this.abrebiatura;
    }

    public void setAbrebiatura(String v) {
        this.abrebiatura = v;
    }

    public Double getPrecioVentaTmp() {
        return this.precioVentaTmp;
    }

    public void setPrecioVentaTmp(Double v) {
        this.precioVentaTmp = v;
    }

    public Integer getCantidadActualTmp() {
        return this.cantidadActualTmp;
    }

    public void setCantidadActualTmp(Integer v) {
        this.cantidadActualTmp = v;
    }

    
    public Collection<MovimientoHistoricoProducto> getMovimientoHistoricoProductoCollection() {
        return this.movimientoHistoricoProductoCollection;
    }
    
    
    public void setMovimientoHistoricoProductoCollection(Collection<MovimientoHistoricoProducto>  v) {
        this.movimientoHistoricoProductoCollection = v;
    }
    
    public Collection<MovimientoOperativoAlmacenDetalle> getMovimientoOperativoAlmacenDetalleCollection() {
        return this.movimientoOperativoAlmacenDetalleCollection;
    }
    
    
    public void setMovimientoOperativoAlmacenDetalleCollection(Collection<MovimientoOperativoAlmacenDetalle>  v) {
        this.movimientoOperativoAlmacenDetalleCollection = v;
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
    
    public Collection<EntradaAlmacenDetalle> getEntradaAlmacenDetalleCollection() {
        return this.entradaAlmacenDetalleCollection;
    }
    
    
    public void setEntradaAlmacenDetalleCollection(Collection<EntradaAlmacenDetalle>  v) {
        this.entradaAlmacenDetalleCollection = v;
    }
    // Getter and Setters @ManyToMany Collection<Multimedio>
    
    public Collection<Multimedio> getMultimedioCollection() {
        return this.multimedioCollection;
    }
    
    
    public void setMultimedioCollection(Collection<Multimedio>  v) {
        this.multimedioCollection = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = (id != null ? id.hashCode() : 0 );
        return hash;
    }

    public boolean equals(Object o){

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof Producto)) {
            return false;
        }

    	Producto other = (Producto ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return nombre + ", " + presentacion;
    }

}
