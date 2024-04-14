package com.cp.UniCursosCP2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProfessorDTO {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String especialidade;

    private boolean fluenciaIngles;

    private boolean fluenciaPortugues;

    @NotNull
    private LocalDate dataInicioExperienciaTecnologia;

    private int anosExperienciaTecnologia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isFluenciaIngles() {
        return fluenciaIngles;
    }

    public void setFluenciaIngles(boolean fluenciaIngles) {
        this.fluenciaIngles = fluenciaIngles;
    }

    public boolean isFluenciaPortugues() {
        return fluenciaPortugues;
    }

    public void setFluenciaPortugues(boolean fluenciaPortugues) {
        this.fluenciaPortugues = fluenciaPortugues;
    }

    public LocalDate getDataInicioExperienciaTecnologia() {
        return dataInicioExperienciaTecnologia;
    }

    public void setDataInicioExperienciaTecnologia(LocalDate dataInicioExperienciaTecnologia) {
        this.dataInicioExperienciaTecnologia = dataInicioExperienciaTecnologia;
    }

    public int getAnosExperienciaTecnologia() {
        return anosExperienciaTecnologia;
    }

    public void setAnosExperienciaTecnologia(int anosExperienciaTecnologia) {
        this.anosExperienciaTecnologia = anosExperienciaTecnologia;
    }
}