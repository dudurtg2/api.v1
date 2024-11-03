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

import com.advocate.api.v1.entities.Calendario;
import com.advocate.api.v1.repositories.CalendarioRepository;
@RestController 
@RequestScope
@RequestMapping("/calendario")
public class CalendarioController {
    CalendarioRepository calendarioRepository;

    @Autowired
    public CalendarioController(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Calendario> findById(@PathVariable int id) {
        Calendario calendarios = this.calendarioRepository.findById(id);

        return new ResponseEntity<Calendario>(calendarios, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Calendario> save(@RequestBody Calendario calendario) {
        Calendario calendarios = this.calendarioRepository.save(calendario);
        return new ResponseEntity<Calendario>(calendarios, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        this.calendarioRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Calendario>> findAll() {
        List<Calendario> calendarios = this.calendarioRepository.findAll();
        return new ResponseEntity<List<Calendario>>(calendarios, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Calendario> update(@PathVariable int id, @RequestBody Calendario calendario) {
        Calendario calendarios = this.calendarioRepository.findById(id);
        calendarios.setNome(calendario.getNome());
        calendarios.setDescrisao(calendario.getDescrisao());
        calendarios.setData(calendario.getData());
        calendarios.setAlerta(calendario.getAlerta());
        calendarios.setFuncionarios(calendario.getFuncionarios());
        return new ResponseEntity<Calendario>(this.calendarioRepository.save(calendarios), HttpStatus.OK);
    }
    
}
