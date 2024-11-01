package com.advocate.api.v1.controlleis;

import javax.print.Doc;

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

import com.advocate.api.v1.entities.DocumentoProcessos;
import com.advocate.api.v1.repositories.DocumentoProcessosRepository;
@RestController 
@RequestScope
@RequestMapping("/documentos/processos")
public class DocumentoProcessosController {
    DocumentoProcessosRepository documentoProcessosRepository;

    @Autowired
    public DocumentoProcessosController(DocumentoProcessosRepository documentoProcessosRepository) {
        this.documentoProcessosRepository = documentoProcessosRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DocumentoProcessos> findById(@PathVariable int id) {
        DocumentoProcessos documentoProcessos = this.documentoProcessosRepository.findById(id);

        return new ResponseEntity<DocumentoProcessos>(documentoProcessos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<DocumentoProcessos> save(@RequestBody DocumentoProcessos documentoProcessos) {
        DocumentoProcessos documentoProcesso = this.documentoProcessosRepository.save(documentoProcessos);
        return new ResponseEntity<DocumentoProcessos>(documentoProcesso, HttpStatus.CREATED);
    }
    
}
