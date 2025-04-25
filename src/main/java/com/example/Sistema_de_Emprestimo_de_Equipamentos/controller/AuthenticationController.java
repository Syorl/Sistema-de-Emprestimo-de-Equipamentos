package com.example.Sistema_de_Emprestimo_de_Equipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.Service.UserService;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.user.User;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.dto.AuthenticationRegister;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.dto.AuthenticationResponse;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> create( @RequestBody AuthenticationRegister user) throws Exception {
        User userCreated = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login( @RequestBody AuthenticationResponse user) throws Exception {
        String userLogin= userService.login(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userLogin);
    }

}
