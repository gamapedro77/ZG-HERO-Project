package com.linketinder.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nome;

    @ManyToMany(mappedBy = "competencias")
    Set<Candidato> candidatos;
    public Competencia() {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
