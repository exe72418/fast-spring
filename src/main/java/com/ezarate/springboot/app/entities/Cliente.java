package com.ezarate.springboot.app.springcloud.entities;

import jakarta.persistence.*;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente") // Optional table name mapping
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long id;

    @Column(nullable = false, unique = true)
    private Long cuit;

    @Column(nullable = false)
    private String apellidoNombre;

    private Long telefono;

    private String email;

    private String domicilio;

    private String zona;

    private boolean disponible = true;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long cuit, String apellidoNombre, Long telefono, String email, String domicilio, Collection<Pedido> pedidos) {
        this.cuit = cuit;
        this.apellidoNombre = apellidoNombre;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Collection<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}