package com.example.Sistema_de_Emprestimo_de_Equipamentos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Funcionario;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;


    public void save(Funcionario funcionario) {
        if(funcionario.getEmail() == null) {
            throw new RuntimeException("Funcionario sem email");
        }if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Funcionario já cadastrado");
        }
        repository.save(funcionario);
        
    }


    

}
