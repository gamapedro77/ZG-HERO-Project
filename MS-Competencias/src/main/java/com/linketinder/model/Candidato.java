package com.linketinder.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    @Column(length = 36, nullable = false)
    private String nome;


    @Column(length = 11, nullable = false)
    private String cpf;

    private String email;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private Date dataNascimento;
    private String descricao;
    private String pais;


    @ManyToMany
    @JoinTable(name="candidato_competencia", joinColumns = @JoinColumn(name="candidato_id"), inverseJoinColumns = @JoinColumn(name="competencia_id"))
    private List<Competencia> competencias;

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void addCompetencia(Competencia competencia) {
        competencias.add(competencia);
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
