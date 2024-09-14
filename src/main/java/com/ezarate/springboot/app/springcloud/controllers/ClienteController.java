package com.ezarate.springboot.app.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ezarate.springboot.app.springcloud.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import com.ezarate.springboot.app.springcloud.entities.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> list() {
        return service.findAll();
    }
    
}
