package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lineas_de_producto") // Opcional: Nombre de la tabla en la base de datos
public class LineaDeProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // Opcional: Estrategia de fetching
    @JoinColumn(name = "producto_id", nullable = false) // Columna de clave foránea
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal; // Asumiendo que subtotal es un número decimal

    // Constructor vacío (requerido por JPA)
    public LineaDeProducto() {
    }

    // Constructor con parámetros
    public LineaDeProducto(Producto producto, Integer cantidad, Double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}