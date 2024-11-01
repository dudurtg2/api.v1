package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    public Clientes findById(int id);
}
