package com.cp.UniCursosCP2.controller;

import com.cp.UniCursosCP2.dto.AlunoDTO;
import com.cp.UniCursosCP2.dto.CursoDTO;
import com.cp.UniCursosCP2.dto.ProfessorDTO;
import com.cp.UniCursosCP2.modal.Curso;
import com.cp.UniCursosCP2.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<EntityModel<CursoDTO>>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();

        List<EntityModel<CursoDTO>> cursosModel = cursos.stream()
                .map(curso -> {
                    CursoDTO cursoDTO = toCursoDTO(curso); // Convertendo Curso para CursoDTO
                    return EntityModel.of(cursoDTO,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).detalhesCurso(cursoDTO.getId())).withSelfRel(),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).professoresDoCurso(cursoDTO.getId())).withRel("professores"),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).alunosInscritosNoCurso(cursoDTO.getId())).withRel("alunosInscritos"));
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(cursosModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Curso>> detalhesCurso(Long id) {
        Curso curso = cursoService.buscarCursoPorId(id);
        EntityModel<Curso> cursoModel = EntityModel.of(curso);
        cursoModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).listarCursos()).withRel("todosCursos"));
        return ResponseEntity.ok(cursoModel);
    }

    @GetMapping("/{id}/professores")
    public ResponseEntity<List<EntityModel<ProfessorDTO>>> professoresDoCurso(Long id) {
        List<ProfessorDTO> professores = cursoService.listarProfessoresDoCurso(id);
        List<EntityModel<ProfessorDTO>> professoresModel = professores.stream()
                .map(professor -> EntityModel.of(professor,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfessorController.class).detalhesProfessor(professor.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(professoresModel);
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<EntityModel<AlunoDTO>>> alunosInscritosNoCurso(Long id) {
        List<AlunoDTO> alunos = cursoService.listarAlunosInscritosNoCurso(id);
        List<EntityModel<AlunoDTO>> alunosModel = alunos.stream()
                .map(aluno -> EntityModel.of(aluno,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AlunoController.class).detalhesAluno(aluno.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(alunosModel);
    }

    private CursoDTO toCursoDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());
        return cursoDTO;
    }
}
