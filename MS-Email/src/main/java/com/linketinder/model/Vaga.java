package com.linketinder.model;

public class Vaga {

    String nome;
    String descricao;
    String local;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
