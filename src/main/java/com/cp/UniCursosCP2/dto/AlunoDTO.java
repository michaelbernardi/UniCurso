package  com.cp.UniCursosCP2.dto;
import com.cp.UniCursosCP2.modal.Curso;
import com.cp.UniCursosCP2.modal.Inscricao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AlunoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Email
    private String email;

    private Integer idade;
    private String pais;
    private Date graduacao;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    private List<Inscricao> inscricoes = new ArrayList<>();

    @ManyToMany
    private List<Curso> cursos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Date graduacao) {
        this.graduacao = graduacao;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}