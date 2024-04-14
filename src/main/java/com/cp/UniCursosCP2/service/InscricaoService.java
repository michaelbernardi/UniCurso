package com.cp.UniCursosCP2.service;

import com.cp.UniCursosCP2.dto.AlunoDTO;
import com.cp.UniCursosCP2.modal.Aluno;
import com.cp.UniCursosCP2.modal.Curso;
import com.cp.UniCursosCP2.modal.Inscricao;
import com.cp.UniCursosCP2.repository.InscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoService alunoService;

    @Transactional(propagation = Propagation.REQUIRED)
    public Inscricao inscreverAlunoEmCurso(Long alunoId, Long cursoId) {
        AlunoDTO aluno = alunoService.buscarAlunoPorId(alunoId);
        Curso curso = cursoService.buscarCursoPorId(cursoId);

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);

        return inscricaoRepository.save(inscricao);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registrarNovoCurso(Curso curso) {
        cursoService.salvarCurso(curso);
    }

    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarInscricaoPorId(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada"));
    }

    public Inscricao salvarInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public void deletarInscricao(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
