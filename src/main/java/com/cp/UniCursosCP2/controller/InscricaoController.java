package com.cp.UniCursosCP2.controller;

import com.cp.UniCursosCP2.modal.Curso;
import com.cp.UniCursosCP2.modal.Inscricao;
import com.cp.UniCursosCP2.service.AlunoService;
import com.cp.UniCursosCP2.service.CursoService;
import com.cp.UniCursosCP2.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Inscricao> listarInscricoes() {
        return inscricaoService.listarInscricoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarInscricaoPorId(@PathVariable Long id) {
        Inscricao inscricao = inscricaoService.buscarInscricaoPorId(id);
        return ResponseEntity.ok(inscricao);
    }

    @PostMapping("/aluno/{alunoId}/curso/{cursoId}")
    public ResponseEntity<Inscricao> inscreverAlunoEmCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        Inscricao inscricao = inscricaoService.inscreverAlunoEmCurso(alunoId, cursoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @PostMapping("/curso")
    public ResponseEntity<Void> registrarNovoCurso(@Valid @RequestBody Curso curso) {
        inscricaoService.registrarNovoCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInscricao(@PathVariable Long id) {
        inscricaoService.deletarInscricao(id);
        return ResponseEntity.noContent().build();
    }
}

