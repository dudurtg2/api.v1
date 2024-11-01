package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.DocumentosClientes;

@Repository
public interface DocumentosClientesRepository extends JpaRepository<DocumentosClientes, Integer> {
    public DocumentosClientes findById(int id);
}
