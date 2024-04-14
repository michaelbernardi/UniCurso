package com.cp.UniCursosCP2.controller;

import com.cp.UniCursosCP2.modal.Materia;
import com.cp.UniCursosCP2.service.MateriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> listarMaterias() {
        return materiaService.listarMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> buscarMateriaPorId(@PathVariable Long id) {
        Materia materia = materiaService.buscarMateriaPorId(id);
        return ResponseEntity.ok(materia);
    }

    @PostMapping
    public ResponseEntity<Materia> criarMateria(@Valid @RequestBody Materia materia) {
        Materia novaMateria = materiaService.salvarMateria(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMateria(@PathVariable Long id) {
        materiaService.deletarMateria(id);
        return ResponseEntity.noContent().build();
    }
}
