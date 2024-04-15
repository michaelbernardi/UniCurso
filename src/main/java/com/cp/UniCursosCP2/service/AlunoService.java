package com.cp.UniCursosCP2.service;

import com.cp.UniCursosCP2.dto.AlunoDTO;
import com.cp.UniCursosCP2.modal.Aluno;
import com.cp.UniCursosCP2.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<AlunoDTO> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
    }

    @Transactional
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    @Transactional
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    @Transactional
    public AlunoDTO atualizarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return convertToDto(alunoAtualizado);
    }

    private AlunoDTO convertToDto(Aluno aluno) {
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    private Aluno convertToEntity(AlunoDTO alunoDTO) {
        return modelMapper.map(alunoDTO, Aluno.class);
    }

    public Object detalhesAluno(Long id) {

        return null;
    }

    private void validarResidencia(String endereco) throws ResidenciaInvalidaException {
        if (!endereco.contains("Brazil")) {
            throw new ResidenciaInvalidaException("O endereço fornecido não corresponde ao país esperado.");
        }
    }

    private void validarGraduacao(LocalDate dataConclusaoGraduacao) throws GraduacaoIncompletaException {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataConclusaoGraduacao, dataAtual);
        if (periodo.getYears() < 5) {
            throw new GraduacaoIncompletaException("O aluno deve ter concluído a graduação há pelo menos 5 anos.");
        }
    }

    private void validarIdadeMinima(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        if (periodo.getYears() < 18) {
            throw new EntityNotFoundException("O aluno deve ter no mínimo 18 anos de idade.");
        }
    }


    private void validarCPF(String cpf) throws CPFInvalidoException {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            throw new CPFInvalidoException("CPF deve conter 11 dígitos.");
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new CPFInvalidoException("CPF inválido (todos os dígitos iguais).");
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador > 9) {
            primeiroDigitoVerificador = 0;
        }

        // Verifica o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
            throw new CPFInvalidoException("CPF inválido (primeiro dígito verificador incorreto).");
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador > 9) {
            segundoDigitoVerificador = 0;
        }

        // Verifica o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != segundoDigitoVerificador) {
            throw new CPFInvalidoException("CPF inválido (segundo dígito verificador incorreto).");
        }
    }
}