package com.example.Sistema_de_Emprestimo_de_Equipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.Service.EmprestimoService;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Emprestimo;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.dto.CadastroEmprestimoDTO;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

     @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarEmprestimo(@RequestBody CadastroEmprestimoDTO dto) {
        try {
            Emprestimo emprestimo = emprestimoService.cadastrarEmprestimo(
                dto.getIdFuncionario(),
                dto.getIdEquipamento(),
                dto.getDataDevolucao()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
