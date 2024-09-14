package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "repartidor") // Opcional: Nombre de la tabla en la base de datos
public class Repartidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private Integer cuit; // Asumiendo que 'cuit' es un número entero

    @Column(nullable = false)
    private String apellidoNombre;

    @Column(nullable = false)
    private String vehiculo;

    @Column(nullable = false)
    private String zona;

    @OneToMany(mappedBy = "repartidor", cascade = CascadeType.ALL)
    private Collection<Entrega> entregas;

    // Constructor vacío (requerido por JPA)
    public Repartidor() {
    }

    // Constructor con parámetros
    public Repartidor(Integer cuit, String apellidoNombre, String vehiculo, String zona) {
        this.cuit = cuit;
        this.apellidoNombre = apellidoNombre;
        this.vehiculo = vehiculo;
        this.zona = zona;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}