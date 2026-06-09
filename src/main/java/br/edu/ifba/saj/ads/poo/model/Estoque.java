package br.edu.ifba.saj.ads.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static List<Equipamento> equipamentos;
    private static List<Funcionario> funcionarios;
    private static List<Registro> registros;
    private static List<Localizacao> localizacoes;

    public Estoque() {
        this.equipamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.localizacoes = new ArrayList<>();
    }

    public void adicionarEquipamento(Equipamento equipamento){
        equipamentos.add(equipamento);

    }

    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void emprestarEquipamento(Equipamento equipamento, Funcionario funcionario){
        if(equipamento.getStatus() == Status.DISPONIVEL){
            equipamento.setStatus(Status.EM_USO);

            Registro novoRegistro = new Registro(funcionario, equipamento,"RETIRADA", LocalDateTime.now());
            registros.add(novoRegistro);
        }
    }

    public void devolverEquipamento(Equipamento equipamento, Funcionario funcionario){
        if(equipamento.getStatus() == Status.EM_USO){
            equipamento.setStatus(Status.DISPONIVEL);

            Registro novoRegistro = new Registro(funcionario, equipamento,"DEVOLUCAO", LocalDateTime.now());
            registros.add(novoRegistro);
        }
    }

    public void consertarEquipamento(Equipamento equipamento, Funcionario funcionario){
        if(equipamento.getStatus() == Status.DISPONIVEL){
            equipamento.setStatus(Status.MANUTENCAO);

            Registro novoRegistro = new Registro(funcionario, equipamento,"MANUTENCAO", LocalDateTime.now());
            registros.add(novoRegistro);
        }
    }

    public void adicionarLocalizacao(Localizacao localizacao){
        localizacoes.add(localizacao);
    }

    public List<Equipamento> getEquipamentos() {
        return List.copyOf(equipamentos);
    }

    public List<Funcionario> getFuncionarios() {
        return List.copyOf(funcionarios);
    }

    public List<Registro> getRegistros() {
        return List.copyOf(registros);
    }

    public List<Localizacao> getLocalizacoes() {
        return List.copyOf(localizacoes);
    }

}
