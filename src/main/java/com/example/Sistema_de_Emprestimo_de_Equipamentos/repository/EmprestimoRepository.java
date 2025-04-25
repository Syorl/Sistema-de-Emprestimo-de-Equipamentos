package com.example.Sistema_de_Emprestimo_de_Equipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, String> {

}
