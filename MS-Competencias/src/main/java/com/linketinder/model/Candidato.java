package com.linketinder.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @OneToMany
    private List<Competencia> competencias;

}
