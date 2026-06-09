package br.edu.ifba.saj.ads.poo.model;

public class Funcionario {
    private int id;
    private String nome;
    private String departamento;

    private static int contadorId = 1;

    public Funcionario(String nome, String departamento) {
        this.id = contadorId;
        this.nome = nome;
        this.departamento = departamento;

        Funcionario.contadorId++;
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
