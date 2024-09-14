package com.ezarate.springboot.app.springcloud.services;

import java.util.List;
import java.util.Optional;

import com.ezarate.springboot.app.springcloud.entities.Cliente;

public interface ClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Optional<Cliente> delete(Cliente cliente);
}