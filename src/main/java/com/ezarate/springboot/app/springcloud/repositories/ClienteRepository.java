package com.ezarate.springboot.app.springcloud.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ezarate.springboot.app.springcloud.entities.Cliente;

public interface ClienteRepository  extends CrudRepository <Cliente, Long> {

    
}
