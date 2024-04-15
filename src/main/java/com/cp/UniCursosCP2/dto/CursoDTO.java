package com.cp.UniCursosCP2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
@Entity
public class CursoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String nome;

    @Size(max = 1000)
    private String descricao;

    @FutureOrPresent
    private LocalDate dataInicio;

    private List<MateriaDTO> materias;

    private List<ProfessorDTO> professores;

    private List<AlunoDTO> alunos;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }

    public List<ProfessorDTO> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorDTO> professores) {
        this.professores = professores;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }
}
