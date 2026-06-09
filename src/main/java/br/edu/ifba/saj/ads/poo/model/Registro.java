package br.edu.ifba.saj.ads.poo.model;

import java.time.LocalDateTime;

public class Registro {
    private Funcionario funcionario;
    private Equipamento equipamento;
    private String acao;
    private LocalDateTime dataDaMudanca;

    public Registro(Funcionario funcionario, Equipamento equipamento, String acao, LocalDateTime dataDaMudanca) {
        this.funcionario = funcionario;
        this.equipamento = equipamento;
        this.acao = acao;
        this.dataDaMudanca = dataDaMudanca;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public String getAcao() {
        return acao;
    }

    public LocalDateTime getDataDaMudanca() {
        return dataDaMudanca;
    }
}
