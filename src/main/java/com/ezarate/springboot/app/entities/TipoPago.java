package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tipo_pago") // Opcional: Nombre de la tabla en la base de datos
public class TipoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL)
    private Collection<Pago> pagos;

    // Constructor vacío (requerido por JPA)
    public TipoPago() {
    }

    // Constructor con parámetros
    public TipoPago(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}