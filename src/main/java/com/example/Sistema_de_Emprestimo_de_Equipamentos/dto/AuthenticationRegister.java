package com.example.Sistema_de_Emprestimo_de_Equipamentos.dto;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.AcessLevels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRegister {

    private String email;
    private String password;
    private AcessLevels role;
}
