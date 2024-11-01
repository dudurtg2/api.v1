package com.advocate.api.v1.controlleis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.advocate.api.v1.entities.Clientes;
import com.advocate.api.v1.repositories.ClientesRepository;
@RestController 
@RequestScope
@RequestMapping("/clientes")
public class ClientesController {
    ClientesRepository clientesRepository;

    @Autowired
    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable int id) {
        Clientes clientes = this.clientesRepository.findById(id);

        return new ResponseEntity<Clientes>(clientes, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Clientes> save(@RequestBody Clientes cliente) {
        Clientes clientes = this.clientesRepository.save(cliente);
        return new ResponseEntity<Clientes>(clientes, HttpStatus.CREATED);
    }
    
}