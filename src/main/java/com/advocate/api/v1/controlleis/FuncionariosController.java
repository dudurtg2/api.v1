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

import com.advocate.api.v1.entities.Funcionarios;
import com.advocate.api.v1.repositories.FuncionariosRepository;
@RestController 
@RequestScope
@RequestMapping("/funcionarios")
public class FuncionariosController {
    FuncionariosRepository funcionariosRepository;

    @Autowired
    public FuncionariosController(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionarios> findById(@PathVariable int id) {
        Funcionarios funcionarios = this.funcionariosRepository.findById(id);

        return new ResponseEntity<Funcionarios>(funcionarios, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Funcionarios> save(@RequestBody Funcionarios funcionario) {
        Funcionarios funcionarios = this.funcionariosRepository.save(funcionario);
        return new ResponseEntity<Funcionarios>(funcionarios, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        this.funcionariosRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionarios>> findAll() {
        List<Funcionarios> funcionarios = this.funcionariosRepository.findAll();
        return new ResponseEntity<List<Funcionarios>>(funcionarios, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionarios> update(@PathVariable int id, @RequestBody Funcionarios funcionario) {
        Funcionarios funcionarios = this.funcionariosRepository.findById(id);
        funcionarios.setNome(funcionario.getNome());
        funcionarios.setEmail(funcionario.getEmail());
        funcionarios.setOab(funcionario.getOab());
        funcionarios.setTelefone(funcionario.getTelefone());
        funcionarios.setSenha(funcionario.getSenha());
        funcionarios.setCpf(funcionario.getCpf());
        return new ResponseEntity<Funcionarios>(this.funcionariosRepository.save(funcionarios), HttpStatus.OK);
    }
}
