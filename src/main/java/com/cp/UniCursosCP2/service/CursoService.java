package com.cp.UniCursosCP2.service;

import com.cp.UniCursosCP2.controller.CourseFullException;
import com.cp.UniCursosCP2.dto.AlunoDTO;
import com.cp.UniCursosCP2.dto.ProfessorDTO;
import com.cp.UniCursosCP2.modal.Curso;
import com.cp.UniCursosCP2.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
    }

    public Curso salvarCurso(Curso curso) {
        if (curso.isFull()) {
            throw new CourseFullException("O curso atingiu o limite de inscrições");
        }
        return cursoRepository.save(curso);
    }


    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }


    public List<AlunoDTO> listarAlunosInscritosNoCurso(Long id) {
        Curso curso = buscarCursoPorId(id);
        return curso.getAlunos().stream()
                .map(aluno -> {
                    AlunoDTO alunoDTO = new AlunoDTO();
                    alunoDTO.setId(aluno.getId());
                    alunoDTO.setNome(aluno.getNome());
                    alunoDTO.setEmail(aluno.getEmail());
                    alunoDTO.setIdade(aluno.getIdade());
                    alunoDTO.setPais(aluno.getPais());
                    alunoDTO.setGraduacao(aluno.getGraduacao());
                    return alunoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<ProfessorDTO> listarProfessoresDoCurso(Long id) {
        Curso curso = buscarCursoPorId(id);
        return curso.getProfessores().stream()
                .map(professor -> {
                    ProfessorDTO professorDTO = new ProfessorDTO();
                    professorDTO.setId(professor.getId());
                    professorDTO.setNome(professor.getNome());
                    professorDTO.setEspecialidade(professor.getEspecialidade());
                    return professorDTO;
                })
                .collect(Collectors.toList());
    }
}
