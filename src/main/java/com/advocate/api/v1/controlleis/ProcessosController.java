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

import com.advocate.api.v1.entities.Processos;
import com.advocate.api.v1.repositories.ProcessosRepository;
@RestController 
@RequestScope
@RequestMapping("/processos")
public class ProcessosController {
    ProcessosRepository processosRepository;

    @Autowired
    public ProcessosController(ProcessosRepository processosRepository) {
        this.processosRepository = processosRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Processos> findById(@PathVariable int id) {
        Processos processos = this.processosRepository.findById(id);

        return new ResponseEntity<Processos>(processos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Processos> save(@RequestBody Processos processo) {
        Processos processos = this.processosRepository.save(processo);
        return new ResponseEntity<Processos>(processos, HttpStatus.CREATED);
    }
    
}