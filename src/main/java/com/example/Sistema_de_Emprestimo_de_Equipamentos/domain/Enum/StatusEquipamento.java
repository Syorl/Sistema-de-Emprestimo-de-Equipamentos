package com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum;

public enum StatusEquipamento {

    DISPONIVEL("Disponivel"),
    INDISPONIVEL("Indisponivel"),
    EM_MANUTENCAO("Em manutencao"),
    BAIXO_ESTOQUE("Baixo estoque");

    private final String status;

    StatusEquipamento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
