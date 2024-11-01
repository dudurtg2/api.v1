package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.DocumentoProcessos;

@Repository
public interface DocumentoProcessosRepository extends JpaRepository<DocumentoProcessos, Integer> {
    public DocumentoProcessos findById(int id);
}
