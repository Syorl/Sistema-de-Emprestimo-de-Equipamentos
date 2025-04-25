package com.example.Sistema_de_Emprestimo_de_Equipamentos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.AcessLevels;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private AcessLevels acessLevels = AcessLevels.USER;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User idUser;

    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Z][a-z]*", message =
    "Surname must start with an uppercase letter.")
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Email
    @Column(unique = true)
    private String cpf;

    @Email
    @Column(unique = true)
    private String telefone;

    @Column(name = "password")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).*$", message = "Password must contain one uppercase, one lowercase, one number, and one special character.")
    private String password;

    @OneToMany
    @JsonBackReference
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), acessLevels);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj) || getClass() != obj.getClass())
            return false;
        Funcionario funcionario = (Funcionario) obj;
        return acessLevels == funcionario.acessLevels;
    }

    public void addAgendamento(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

}
