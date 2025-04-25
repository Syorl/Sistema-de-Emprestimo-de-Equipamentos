package com.example.Sistema_de_Emprestimo_de_Equipamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

    Optional<Funcionario> findByEmail(String username);
    boolean existsByEmail(String email);

}
