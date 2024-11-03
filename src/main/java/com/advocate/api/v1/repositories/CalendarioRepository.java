package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {
    public Calendario findById(int id);
}
