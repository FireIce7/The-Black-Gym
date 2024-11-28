package model;

import java.time.LocalDateTime;

public class Manutencao {
    private String equipamento;
    private String descricao;
    private FuncionarioLimpeza funcionario;
    private LocalDateTime data;

    public Manutencao(String equipamento, String descricao, FuncionarioLimpeza funcionario, LocalDateTime data) {
        this.equipamento = equipamento;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.data = data;
    }

    // Getters
    public String getEquipamento() {
        return equipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public FuncionarioLimpeza getFuncionario() {
        return funcionario;
    }

    public LocalDateTime getData() {
        return data;
    }
}
