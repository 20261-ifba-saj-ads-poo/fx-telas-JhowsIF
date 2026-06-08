package br.edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Ingresso> ingressos;
    private String nome;
    private String cpf;
    private LocalDate nascimento;

    public Cliente(String nome, String cpf, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.ingressos = new ArrayList<>();
    }

    public void addIngresso(Ingresso ingressoVendido) {
        ingressos.add(ingressoVendido);
    }

    public List<Ingresso> getIngressos() {
        return List.copyOf(ingressos);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    

}
