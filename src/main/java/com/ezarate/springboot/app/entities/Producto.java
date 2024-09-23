package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "producto") // Opcional: Nombre de la tabla en la base de datos
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long codigo; // Asumiendo que 'codigo' es un número entero

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer stock; // Asumiendo que 'stock' es un número entero

    @Column(nullable = false)
    private Double precio; // Asumiendo que 'precio' es un número decimal

    @ManyToOne(fetch = FetchType.EAGER) // Opcional: Estrategia de fetching
    @JoinColumn(name = "tipo_producto_id", nullable = false) // Columna de clave foránea
    private TipoProducto tipoProducto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Collection<LineaDeProducto> lineas;

    // Constructor vacío (requerido por JPA)
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String descripcion, Integer stock, Double precio, TipoProducto tipoProducto) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}