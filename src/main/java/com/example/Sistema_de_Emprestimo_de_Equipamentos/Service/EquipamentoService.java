package com.example.Sistema_de_Emprestimo_de_Equipamentos.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Equipamento;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public void save(Equipamento equipamento) {
        repository.save(equipamento);
    }

    public Optional<Equipamento> findByCode(String code) {
        return repository.findByCode(code);
    }

    

}
