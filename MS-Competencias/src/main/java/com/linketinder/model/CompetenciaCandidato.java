package com.linketinder.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CompetenciaCandidato {

    @Id
    private int id;

    @ManyToOne(targetEntity = Competencia.class)
    private int idCompetencia;

    @ManyToOne(targetEntity = Candidato.class)
    private int idCandidato;
}
