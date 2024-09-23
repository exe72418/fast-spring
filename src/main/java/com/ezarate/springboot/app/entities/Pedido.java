package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "pedido") // Optional table name mapping
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long nroPedido;

    @Column(nullable = false)
    private Date fecha;

    private Double total; // Assuming total is a double

    @ManyToOne(fetch = FetchType.EAGER) // Optional fetch strategy for Cliente
    @JoinColumn(name = "cliente_id", nullable = false) // Foreign key column mapping
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY) // Optional fetch strategy for Entrega
    @JoinColumn(name = "entrega_id") // Foreign key column mapping
    private Entrega entrega;

    @OneToOne(fetch = FetchType.LAZY) // Optional fetch strategy for Pago
    @JoinColumn(name = "pago_id") // Foreign key column mapping
    private Pago pago;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Collection<LineaDeProducto> lineas;

    public Pedido() {
    }

    public Pedido(Date fecha, Double total, Cliente cliente, Entrega entrega, Pago pago, Collection<LineaDeProducto> lineas) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.entrega = entrega;
        this.pago = pago;
        this.lineas = lineas;
    }

    public Long getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(Long nroPedido) {
        this.nroPedido = nroPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Collection<LineaDeProducto> getLineas() {
        return lineas;
    }

    public void setLineas(Collection<LineaDeProducto> lineas) {
        this.lineas = lineas;
    }
}