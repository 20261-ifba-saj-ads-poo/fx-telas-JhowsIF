package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private List<Sessao> sessoes;
    private String nome;
    private float duracao;

    public Filme(String nome, float duracao) {
        this.nome = nome;
        this.duracao = duracao;
        this.sessoes = new ArrayList<>();
    }

    public void addSessao(Sessao sessao) {
        if(!this.equals(sessao.getFilme())){
            sessao.setFilme(this);
        }
        if(!sessoes.contains(sessao)){
            sessoes.add(sessao);
        }

    }

    public List<Sessao> getSessoes() {
        return List.copyOf(sessoes);
    }

    public String getNome() {
        return nome;
    }

    public float getDuracao() {
        return duracao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + Float.floatToIntBits(duracao);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Filme f){
            return f.getNome().equals(nome) && f.getDuracao() == duracao;            
        }
        return false;
    }   

}
