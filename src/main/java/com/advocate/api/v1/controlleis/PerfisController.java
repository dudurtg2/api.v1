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

import com.advocate.api.v1.entities.Perfil;
import com.advocate.api.v1.repositories.PerfisRepository;
@RestController 
@RequestScope
@RequestMapping("/perfis")
public class PerfisController {
    PerfisRepository perfisRepository;

    @Autowired
    public PerfisController(PerfisRepository perfisRepository) {
        this.perfisRepository = perfisRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Perfil> findById(@PathVariable int id) {
        Perfil perfis = this.perfisRepository.findById(id);

        return new ResponseEntity<Perfil>(perfis, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
        Perfil perfis = this.perfisRepository.save(perfil);
        return new ResponseEntity<Perfil>(perfis, HttpStatus.CREATED);
    }
    
}
