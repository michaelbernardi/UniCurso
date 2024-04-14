package com.cp.UniCursosCP2.controller;

import com.cp.UniCursosCP2.modal.Professor;
import com.cp.UniCursosCP2.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listarProfessores() {
        return professorService.listarProfessores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        Professor professor = professorService.buscarProfessorPorId(id);
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@Valid @RequestBody Professor professor) {
        Professor novoProfessor = professorService.salvarProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Professor>> detalhesProfessor(@PathVariable Long id) {
        Professor professor = professorService.buscarProfessorPorId(id);

        EntityModel<Professor> professorModel = EntityModel.of(professor);
        return ResponseEntity.ok(professorModel);
    }
}
