package com.example.Sistema_de_Emprestimo_de_Equipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.Service.FuncionarioService;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;


    @PostMapping
    public void save(Funcionario funcionario) {
        service.save(funcionario);
    }

}
