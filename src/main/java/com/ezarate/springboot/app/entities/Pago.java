package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago") // Opcional: Nombre de la tabla en la base de datos
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER) // Opcional: Estrategia de fetching
    @JoinColumn(name = "tipo_pago_id", nullable = false) // Columna de clave foránea
    private TipoPago tipoPago;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    // Constructor vacío (requerido por JPA)
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(Date fecha, TipoPago tipoPago, Pedido pedido) {
        this.fecha = fecha;
        this.tipoPago = tipoPago;
        this.pedido = pedido;
    }

    // Getters y setters
    // ... (generados automáticamente por tu IDE)
}