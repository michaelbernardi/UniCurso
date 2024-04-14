package com.cp.UniCursosCP2.service;

import com.cp.UniCursosCP2.modal.Materia;
import com.cp.UniCursosCP2.repository.MateriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> listarMaterias() {
        return materiaRepository.findAll();
    }

    public Materia buscarMateriaPorId(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada"));
    }

    public Materia salvarMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void deletarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

}
