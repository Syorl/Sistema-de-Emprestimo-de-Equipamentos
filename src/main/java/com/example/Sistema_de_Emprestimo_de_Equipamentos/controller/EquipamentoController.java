package com.example.Sistema_de_Emprestimo_de_Equipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.Service.EquipamentoService;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Equipamento;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;


    @PostMapping
    public void save(Equipamento equipamento) {
        equipamentoService.save(equipamento);
    }

}
