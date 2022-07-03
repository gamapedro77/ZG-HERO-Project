package com.example.linketindertreco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    @Column(length = 36, nullable = false)
    private String nome;
    
    @Column(length = 36, nullable = false)
    private String sobrenome;
    @Column(length = 11, nullable = false)
    private String cpf;

    private String email;

    private String senha;


}
