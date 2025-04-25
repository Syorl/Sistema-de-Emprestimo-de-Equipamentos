package com.example.Sistema_de_Emprestimo_de_Equipamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Equipamento;
@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, String> {

    Optional<Equipamento> findByCode(String code);

}
