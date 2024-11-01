package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.Processos;


@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Integer> {
    public Processos findById(int id);
}
