package com.advocate.api.v1.controlleis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/findAll")
    public ResponseEntity<List<Clientes>> findAll() {
        List<Clientes> clientes = this.clientesRepository.findAll();
        return new ResponseEntity<List<Clientes>>(clientes, HttpStatus.OK);
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
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        this.clientesRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Clientes> update(@PathVariable int id, @RequestBody Clientes cliente) {
        Clientes clientes = this.clientesRepository.findById(id);
        clientes.setNome(cliente.getNome());
        clientes.setCpf(cliente.getCpf());
        clientes.setNascionalidade(cliente.getNascionalidade());
        clientes.setEstadoCivil(cliente.getEstadoCivil());    
        clientes.setProficao(cliente.getProficao());
        clientes.setEndereco(cliente.getEndereco());
        clientes.setEmail(cliente.getEmail());
        clientes.setDataNascimento(cliente.getDataNascimento());
        clientes.setTelefoneCelular(cliente.getTelefoneCelular());
        clientes.setTelefoneFixo(cliente.getTelefoneFixo());
        
        return new ResponseEntity<Clientes>(this.clientesRepository.save(clientes), HttpStatus.OK);
    }
}
