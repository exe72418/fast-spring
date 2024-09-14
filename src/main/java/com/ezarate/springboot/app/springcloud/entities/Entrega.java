package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "entrega") // Opcional: Nombre de la tabla en la base de datos
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Integer lote; // Asumiendo que 'lote' es un número entero

    @Column(nullable = false)
    private String zona;

    @ManyToOne(fetch = FetchType.EAGER) // Opcional: Estrategia de fetching
    @JoinColumn(name = "repartidor_id", nullable = false) // Columna de clave foránea
    private Repartidor repartidor;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private Collection<Pedido> pedidos;

    // Constructor vacío (requerido por JPA)
    public Entrega() {
    }

    // Constructor con parámetros
    public Entrega(Date fecha, Integer lote, String zona, Repartidor repartidor) {
        this.fecha = fecha;
        this.lote = lote;
        this.zona = zona;
        this.repartidor = repartidor;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}