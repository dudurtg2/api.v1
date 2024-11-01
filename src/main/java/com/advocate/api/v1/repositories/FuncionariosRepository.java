package com.advocate.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advocate.api.v1.entities.Funcionarios;


@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {
    public Funcionarios findByEmail(String email);
    public Funcionarios findById(int id);
    public Funcionarios findByPerfilId(int id);
}
