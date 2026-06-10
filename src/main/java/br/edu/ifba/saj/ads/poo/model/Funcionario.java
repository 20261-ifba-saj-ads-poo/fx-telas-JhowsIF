package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int id;
    private String nome;
    private String departamento;
    private List<Registro> registros;

    private static int contadorId = 1;

    public Funcionario(String nome, String departamento) {
        this.id = contadorId;
        this.nome = nome;
        this.departamento = departamento;
        this.registros = new ArrayList<>();

        Funcionario.contadorId++;
    }

    public void adicionarRegistro(Registro registro){
        this.registros.add(registro);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
