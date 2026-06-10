package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private int id;
    private String nome;
    private int numeroDeSerie;
    private Localizacao localizacao;
    private Status status;
    private List<Registro> registros;

    private static int contadorId = 1;

    public Equipamento(String nome, int numeroDeSerie, Localizacao localizacao) {
        this.id = contadorId;
        this.nome = nome;
        this.numeroDeSerie = numeroDeSerie;
        this.localizacao = localizacao;
        this.status = Status.DISPONIVEL;
        this.registros = new ArrayList<>();

        Equipamento.contadorId++;
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

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public Status getStatus() {
        return status;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Registro> getRegistros() {
        return List.copyOf(registros);
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
