package com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum;

public enum StatusEmprestimo {

    ATRASADO("Atrasado"),
    PENDENTE("Pendente"),
    CONCLUIDO("Concluido");

    private final String status;

    StatusEmprestimo(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
