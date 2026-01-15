package com.tIdadeConect.T_IdadeConect.Services;

import com.tIdadeConect.T_IdadeConect.Entities.Cursos;
import com.tIdadeConect.T_IdadeConect.Entities.Modulos;
import com.tIdadeConect.T_IdadeConect.repositories.CursosRepository;
import com.tIdadeConect.T_IdadeConect.repositories.ModulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModulosServices {

    @Autowired
    private ModulosRepository modulosRepository;

    @Autowired
    private CursosRepository cursosRepository;

    public Modulos criarModulo(Modulos modulos) {
        // Busca o curso do banco para garantir que existe
        if (modulos.getCurso() != null && modulos.getCurso().getId() != null) {
            Cursos curso = cursosRepository.findById(modulos.getCurso().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
            modulos.setCurso(curso);
        } else {
            throw new RuntimeException("Curso é obrigatório");
        }

        return modulosRepository.save(modulos);
    }

    public List<Modulos> listarModulos() {
        return modulosRepository.findAll();
    }

    public Optional<Modulos> listarModuloId(Long id) {
        return modulosRepository.findById(id);
    }

    public Modulos atualizarModulos(Long id, Modulos novoModulo) {
        Modulos moduloExistente = modulosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modulo não encontrado"));

        moduloExistente.setTitulo(novoModulo.getTitulo());
        moduloExistente.setOrdem(novoModulo.getOrdem());

        // Atualiza o curso se foi informado
        if (novoModulo.getCurso() != null && novoModulo.getCurso().getId() != null) {
            Cursos curso = cursosRepository.findById(novoModulo.getCurso().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
            moduloExistente.setCurso(curso);
        }

        return modulosRepository.save(moduloExistente);
    }

    public void deletarModulo(Long id) {
        modulosRepository.deleteById(id);
    }
}