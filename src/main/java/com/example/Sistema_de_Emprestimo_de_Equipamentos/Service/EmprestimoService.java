package com.example.Sistema_de_Emprestimo_de_Equipamentos.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Emprestimo;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Equipamento;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Funcionario;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.StatusEmprestimo;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.domain.Enum.StatusEquipamento;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.EmprestimoRepository;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.EquipamentoRepository;
import com.example.Sistema_de_Emprestimo_de_Equipamentos.repository.FuncionarioRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Emprestimo cadastrarEmprestimo(String idFuncionario, String idEquipamento, LocalDateTime dataDevolucao) {

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Equipamento equipamento = equipamentoRepository.findById(idEquipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        // Verifica se o equipamento está disponível
        if (equipamento.getStatus() != StatusEquipamento.DISPONIVEL) {
            throw new RuntimeException("Equipamento não está disponível para empréstimo");
        }

        // Verifica se o funcionário tem empréstimo em atraso
        boolean possuiEmprestimoAtrasado = funcionario.getEmprestimos().stream()
                .anyMatch(e -> e.getStatusEmprestimo() == StatusEmprestimo.ATRASADO);

        if (possuiEmprestimoAtrasado) {
            throw new RuntimeException("Funcionário possui empréstimos em atraso");
        }

        // Atualiza status do equipamento
        equipamento.setStatus(StatusEquipamento.INDISPONIVEL);
        equipamentoRepository.save(equipamento);

        // Cria o novo empréstimo
        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setFuncionario(funcionario);
        novoEmprestimo.setEquipamento(equipamento);
        novoEmprestimo.setDataEmprestimo(LocalDateTime.now());
        novoEmprestimo.setDataDevolucao(dataDevolucao);
        novoEmprestimo.setStatusEmprestimo(StatusEmprestimo.PENDENTE);

        return emprestimoRepository.save(novoEmprestimo);
    }
}
