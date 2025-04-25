package com.example.Sistema_de_Emprestimo_de_Equipamentos.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.StatusEquipamento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String code;
    private String descricao;
    private String marca;
    private String modelo;
    private String serial;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento status;

    @OneToMany
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Equipamento that = (Equipamento) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
