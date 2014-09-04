
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
 * Class for mapping JPA Entity of Table Pedido_Venta.
 * m2m
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.8.5
 * @date 2014/08/27 07:01
 */



@Entity
@Table(name = "PEDIDO_VENTA")
public class PedidoVenta implements java.io.Serializable {
    private static final long serialVersionUID = 2008272604;
    
    /**
    * id
    */
    @Id
    @Basic(optional = false)
    @Column(name = "ID"   )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * estado
    */
    @Basic(optional = false)
    @Column(name = "ESTADO"   )
    private int estado;
    
    /**
    * fecha actualizacion
    */
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUALIZACION"   )
    private java.util.Date fechaActualizacion;
    
    /**
    * usuario id
    */
    @JoinColumn(name = "USUARIO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    /**
    * cliente id
    */
    @JoinColumn(name = "CLIENTE_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Cliente cliente;
    
    /**
    * forma de pago id
    */
    @JoinColumn(name = "FORMA_DE_PAGO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private FormaDePago formaDePago;
    
    /**
    * metodo de pago id
    */
    @JoinColumn(name = "METODO_DE_PAGO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private MetodoDePago metodoDePago;
    
    /**
    * factoriva
    */
    @Basic(optional = false)
    @Column(name = "FACTORIVA"   )
    private double factoriva;
    
    /**
    * comentarios
    */
    @Basic(optional = true)
    @Column(name = "COMENTARIOS" , length=255  )
    private String comentarios;
    
    /**
    * descuento aplicado
    */
    @Basic(optional = true)
    @Column(name = "DESCUENTO_APLICADO"   )
    private Double descuentoAplicado;
    
    /**
    * facturable
    */
    @Basic(optional = true)
    @Column(name = "FACTURABLE"   )
    private Integer facturable;
    
    /**
    * cfd venta id
    */
    @JoinColumn(name = "CFD_VENTA_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private CfdVenta cfdVenta;
    
    /**
    * numero ticket
    */
    @Basic(optional = true)
    @Column(name = "NUMERO_TICKET" , length=128  )
    private String numeroTicket;
    
    /**
    * caja
    */
    @Basic(optional = true)
    @Column(name = "CAJA"   )
    private Integer caja;
    
    /**
    * importe recibido
    */
    @Basic(optional = true)
    @Column(name = "IMPORTE_RECIBIDO"   )
    private Double importeRecibido;
    
    /**
    * aprobacion visa mastercard
    */
    @Basic(optional = true)
    @Column(name = "APROBACION_VISA_MASTERCARD" , length=64  )
    private String aprobacionVisaMastercard;
    
    /**
    * mayoreo
    */
    @Basic(optional = true)
    @Column(name = "MAYOREO"   )
    private Integer mayoreo;
    
    /**
    * porcentaje descuento calculado
    */
    @Basic(optional = true)
    @Column(name = "PORCENTAJE_DESCUENTO_CALCULADO"   )
    private Integer porcentajeDescuentoCalculado;
    
    /**
    * porcentaje descuento extra
    */
    @Basic(optional = true)
    @Column(name = "PORCENTAJE_DESCUENTO_EXTRA"   )
    private Integer porcentajeDescuentoExtra;
    
    /**
    * condiciones de pago
    */
    @Basic(optional = true)
    @Column(name = "CONDICIONES_DE_PAGO" , length=128  )
    private String condicionesDePago;
    
    /**
    * num de cuenta
    */
    @Basic(optional = true)
    @Column(name = "NUM_DE_CUENTA" , length=32  )
    private String numDeCuenta;
    
    /**
    * motivo descuento
    */
    @Basic(optional = true)
    @Column(name = "MOTIVO_DESCUENTO" , length=128  )
    private String motivoDescuento;
    // bug , must refering Pedido_Venta_Detalle.Pedido_Venta_id => pedidoVentaId, normalized ? true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoVenta")
    private Collection<PedidoVentaDetalle> pedidoVentaDetalleCollection;
    

    /** 
     * Default Constructor
     */
    public PedidoVenta() {
    }

    /** 
     * lazy Constructor just with IDs
     */
    public PedidoVenta( Integer id ) {
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

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int v) {
        this.estado = v;
    }

    public java.util.Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(java.util.Date v) {
        this.fechaActualizacion = v;
    }

    public Usuario getUsuario () {
        return this.usuario;
    }

    public void setUsuario(Usuario v) {
        this.usuario = v;
    }

    public Cliente getCliente () {
        return this.cliente;
    }

    public void setCliente(Cliente v) {
        this.cliente = v;
    }

    public FormaDePago getFormaDePago () {
        return this.formaDePago;
    }

    public void setFormaDePago(FormaDePago v) {
        this.formaDePago = v;
    }

    public MetodoDePago getMetodoDePago () {
        return this.metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago v) {
        this.metodoDePago = v;
    }

    public double getFactoriva() {
        return this.factoriva;
    }

    public void setFactoriva(double v) {
        this.factoriva = v;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String v) {
        this.comentarios = v;
    }

    public Double getDescuentoAplicado() {
        return this.descuentoAplicado;
    }

    public void setDescuentoAplicado(Double v) {
        this.descuentoAplicado = v;
    }

    public Integer getFacturable() {
        return this.facturable;
    }

    public void setFacturable(Integer v) {
        this.facturable = v;
    }

    public CfdVenta getCfdVenta () {
        return this.cfdVenta;
    }

    public void setCfdVenta(CfdVenta v) {
        this.cfdVenta = v;
    }

    public String getNumeroTicket() {
        return this.numeroTicket;
    }

    public void setNumeroTicket(String v) {
        this.numeroTicket = v;
    }

    public Integer getCaja() {
        return this.caja;
    }

    public void setCaja(Integer v) {
        this.caja = v;
    }

    public Double getImporteRecibido() {
        return this.importeRecibido;
    }

    public void setImporteRecibido(Double v) {
        this.importeRecibido = v;
    }

    public String getAprobacionVisaMastercard() {
        return this.aprobacionVisaMastercard;
    }

    public void setAprobacionVisaMastercard(String v) {
        this.aprobacionVisaMastercard = v;
    }

    public Integer getMayoreo() {
        return this.mayoreo;
    }

    public void setMayoreo(Integer v) {
        this.mayoreo = v;
    }

    public Integer getPorcentajeDescuentoCalculado() {
        return this.porcentajeDescuentoCalculado;
    }

    public void setPorcentajeDescuentoCalculado(Integer v) {
        this.porcentajeDescuentoCalculado = v;
    }

    public Integer getPorcentajeDescuentoExtra() {
        return this.porcentajeDescuentoExtra;
    }

    public void setPorcentajeDescuentoExtra(Integer v) {
        this.porcentajeDescuentoExtra = v;
    }

    public String getCondicionesDePago() {
        return this.condicionesDePago;
    }

    public void setCondicionesDePago(String v) {
        this.condicionesDePago = v;
    }

    public String getNumDeCuenta() {
        return this.numDeCuenta;
    }

    public void setNumDeCuenta(String v) {
        this.numDeCuenta = v;
    }

    public String getMotivoDescuento() {
        return this.motivoDescuento;
    }

    public void setMotivoDescuento(String v) {
        this.motivoDescuento = v;
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
        if (!(o instanceof PedidoVenta)) {
            return false;
        }

    	PedidoVenta other = (PedidoVenta ) o;
        if ( (this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }


    	return true;
    }

    @Override
    public String toString() {
        return "com.pmarlen.model.beans.PedidoVenta[id = "+id+ "]";
    }

}
