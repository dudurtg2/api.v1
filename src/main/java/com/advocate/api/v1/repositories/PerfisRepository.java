package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.advocate.api.v1.entities.Perfil;

@Repository
public interface PerfisRepository extends JpaRepository<Perfil, Integer> {
    public Perfil findById(int id);
}
