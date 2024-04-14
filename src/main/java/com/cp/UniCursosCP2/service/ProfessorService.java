package com.cp.UniCursosCP2.service;

import com.cp.UniCursosCP2.modal.Professor;
import com.cp.UniCursosCP2.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor buscarProfessorPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
    }

    public Professor salvarProfessor(@Valid Professor professorDTO) {
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setEspecialidade(professorDTO.getEspecialidade());
        professor.setFluenciaIngles(professorDTO.isFluenciaIngles());
        professor.setFluenciaPortugues(professorDTO.isFluenciaPortugues());
        professor.setDataInicioExperienciaTecnologia(professorDTO.getDataInicioExperienciaTecnologia());

        int anosExperiencia = calcularAnosExperiencia(professorDTO.getDataInicioExperienciaTecnologia());
        professor.setAnosExperienciaTecnologia(anosExperiencia);

        return professorRepository.save(professor);
    }

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    private int calcularAnosExperiencia(LocalDate dataInicioExperienciaTecnologia) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataInicioExperienciaTecnologia, dataAtual);
        return periodo.getYears();
    }
}
