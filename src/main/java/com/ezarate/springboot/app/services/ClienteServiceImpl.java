package com.ezarate.springboot.app.springcloud.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ezarate.springboot.app.springcloud.entities.Cliente;
import com.ezarate.springboot.app.springcloud.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    @Override
    public Optional<Cliente> delete(Cliente cliente) {
        Optional<Cliente> clienteOptional = repository.findById(cliente.getId());
        clienteOptional.ifPresent(clientDb -> {
            repository.delete(clientDb);
        });
        return clienteOptional;
    }

}
