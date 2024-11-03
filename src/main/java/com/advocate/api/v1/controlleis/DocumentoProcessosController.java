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
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        this.documentoProcessosRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DocumentoProcessos>> findAll() {
        List<DocumentoProcessos> documentoProcessos = this.documentoProcessosRepository.findAll();
        return new ResponseEntity<List<DocumentoProcessos>>(documentoProcessos, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentoProcessos> update(@PathVariable int id, @RequestBody DocumentoProcessos documentoProcessos) {
        DocumentoProcessos documentoProcesso = this.documentoProcessosRepository.findById(id);
        documentoProcesso.setTipo(documentoProcessos.getTipo());
        documentoProcesso.setStatus(documentoProcessos.getStatus());
        documentoProcesso.setDescrisao(documentoProcessos.getDescrisao());
        documentoProcesso.setDocumentosClientes(documentoProcessos.getDocumentosClientes());
        return new ResponseEntity<DocumentoProcessos>(this.documentoProcessosRepository.save(documentoProcesso), HttpStatus.OK);
    }
}   

