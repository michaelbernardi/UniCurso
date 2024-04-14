package com.cp.UniCursosCP2.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    private String especialidade;

    private boolean fluenciaIngles;

    private boolean fluenciaPortugues;

    @ManyToMany
    private List<Curso> cursos = new ArrayList<>();

    private LocalDate dataInicioExperienciaTecnologia;

    private LocalDate anosExperienciaTecnologia;

    public LocalDate getAnosExperienciaTecnologia() {
        return anosExperienciaTecnologia;
    }

    public void setAnosExperienciaTecnologia(LocalDate anosExperienciaTecnologia) {
        this.anosExperienciaTecnologia = anosExperienciaTecnologia;
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
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public LocalDate getDataInicioExperienciaTecnologia() {
        return dataInicioExperienciaTecnologia;
    }

    public void setDataInicioExperienciaTecnologia(LocalDate dataInicioExperienciaTecnologia) {
        this.dataInicioExperienciaTecnologia = dataInicioExperienciaTecnologia;
    }

    public void setAnosExperienciaTecnologia(int anosExperiencia) {
        this.anosExperienciaTecnologia = LocalDate.ofEpochDay(anosExperiencia);
    }
}
