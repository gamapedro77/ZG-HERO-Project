package com.linketinder.DTO;

import com.linketinder.model.Competencia;

import java.util.ArrayList;

public class CompetenciasList {

    private ArrayList<Competencia> competencias;

    public CompetenciasList(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }

    public ArrayList<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }
}
