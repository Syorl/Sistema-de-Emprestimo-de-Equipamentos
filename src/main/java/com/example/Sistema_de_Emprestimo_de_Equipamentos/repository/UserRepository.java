package com.example.Sistema_de_Emprestimo_de_Equipamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
