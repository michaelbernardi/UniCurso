package com.cp.UniCursosCP2.repository;
import com.cp.UniCursosCP2.modal.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}

