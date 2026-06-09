package br.edu.ifba.saj.ads.poo.model;

public class Localizacao {
    private int id;
    private String nome;

    private static int contadorId = 1;

    public Localizacao(String nome) {
        this.id = contadorId;
        this.nome = nome;

        Localizacao.contadorId++;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
