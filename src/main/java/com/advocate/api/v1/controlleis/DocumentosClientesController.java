package com.advocate.api.v1.controlleis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.advocate.api.v1.entities.DocumentosClientes;
import com.advocate.api.v1.repositories.DocumentosClientesRepository;
@RestController 
@RequestScope
@RequestMapping("/documentos/clientes")
public class DocumentosClientesController {
    DocumentosClientesRepository documentosClientesRepository;

    @Autowired
    public DocumentosClientesController(DocumentosClientesRepository documentosClientesRepository) {
        this.documentosClientesRepository = documentosClientesRepository;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DocumentosClientes> findById(@PathVariable int id) {
        DocumentosClientes documentosClientes = this.documentosClientesRepository.findById(id);

        return new ResponseEntity<DocumentosClientes>(documentosClientes, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<DocumentosClientes> save(@RequestBody DocumentosClientes documentosCliente) {
        DocumentosClientes documentosClientes = this.documentosClientesRepository.save(documentosCliente);
        return new ResponseEntity<DocumentosClientes>(documentosClientes, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<DocumentosClientes> update(@PathVariable int id, @RequestBody DocumentosClientes documentosCliente) {
        DocumentosClientes documentosClientes = this.documentosClientesRepository.findById(id);
        documentosClientes.setLinkRg(documentosCliente.getLinkRg());
        documentosClientes.setLinkResidencia(documentosCliente.getLinkResidencia());
        documentosClientes.setLinkEstadoCivil(documentosCliente.getLinkEstadoCivil());
        documentosClientes.setLinkProvas(documentosCliente.getLinkProvas());
        return new ResponseEntity<DocumentosClientes>(this.documentosClientesRepository.save(documentosClientes), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        this.documentosClientesRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<DocumentosClientes>> findAll() {
        List<DocumentosClientes> documentosClientes = this.documentosClientesRepository.findAll();
        return new ResponseEntity<List<DocumentosClientes>>(documentosClientes, HttpStatus.OK);
    }
    
}
