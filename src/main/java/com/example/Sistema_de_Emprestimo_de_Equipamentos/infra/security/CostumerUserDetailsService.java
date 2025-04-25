package com.example.Sistema_de_Emprestimo_de_Equipamentos.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Funcionario;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.AcessLevels;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.user.User;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.FuncionarioRepository;


@Service
public class CostumerUserDetailsService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Funcionario " + username + " not found."));
        if (funcionario != null){
            return createUsers(funcionario.getEmail(), funcionario.getPassword(), funcionario.getAcessLevels());
        }
        throw new UsernameNotFoundException("User not found with email: " + username);
    }

    private User createUsers(String email, String password, AcessLevels role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAcessLevels(role);
        return user;
    }

}
