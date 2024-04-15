package com.cp.UniCursosCP2.controller;

import com.cp.UniCursosCP2.dto.AlunoDTO;
import com.cp.UniCursosCP2.modal.Aluno;
import com.cp.UniCursosCP2.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@Validated
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoAtualizado = alunoService.atualizarAluno(id, alunoDTO);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<?> detalhesAluno(@PathVariable Long id) {
        Object detalhes = alunoService.detalhesAluno(id); // Você precisa implementar este método no AlunoService
        return ResponseEntity.ok(detalhes);
    }
}


