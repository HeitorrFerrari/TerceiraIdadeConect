package com.tIdadeConect.T_IdadeConect.Services;

import com.tIdadeConect.T_IdadeConect.Entities.Cursos;
import com.tIdadeConect.T_IdadeConect.repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosServices {

    @Autowired
    private CursosRepository cursosRepository;

    public Cursos criarCurso (Cursos cursos) {
        return cursosRepository.save(cursos);
    }

    public List<Cursos> buscarCursos() {
        return cursosRepository.findAll();
    }

    public Optional<Cursos> buscarUnicoCurso (Long id) {
        return cursosRepository.findById(id);
    }

    public Cursos atualizarCurso (Long id, Cursos novoCurso) {

        Cursos cursoExistente = cursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoExistente.setTitulo(novoCurso.getTitulo());
        cursoExistente.setDescricao(novoCurso.getDescricao());

        return cursosRepository.save(cursoExistente);
    }

    public void deletarCurso (Long id) {
        cursosRepository.deleteById(id);
    }

}
