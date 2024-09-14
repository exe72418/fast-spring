package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tipo_producto") // Opcional: Nombre de la tabla en la base de datos
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoProducto", cascade = CascadeType.ALL)
    private Collection<Producto> productos;

    // Constructor vacío (requerido por JPA)
    public TipoProducto() {
    }

    // Constructor con parámetros
    public TipoProducto(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}