package com.example.Sistema_de_Emprestimo_de_Equipamentos.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CadastroEmprestimoDTO {
    private String idFuncionario;
    private String idEquipamento;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataDevolucao;
}
