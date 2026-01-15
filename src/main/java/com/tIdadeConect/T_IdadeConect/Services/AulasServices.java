package com.tIdadeConect.T_IdadeConect.Services;

import com.tIdadeConect.T_IdadeConect.Entities.Aulas;
import com.tIdadeConect.T_IdadeConect.repositories.AulasRepository;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulasServices {

    @Autowired
    private AulasRepository aulasRepository;

    public Aulas criarAula (Aulas aulas) {
        return aulasRepository.save(aulas);
    }

    public List<Aulas> listarAulas() {
        return aulasRepository.findAll();
    }

    public Optional<Aulas> listarAulaId (Long id) {
        return aulasRepository.findById(id);
    }

    public Aulas atualizarAulas (Long id, Aulas novaAula) {

        Aulas aulaExistente = aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        aulaExistente.setTitulo(novaAula.getTitulo());
        aulaExistente.setModulo(novaAula.getModulo());
        aulaExistente.setVideoUrl(novaAula.getVideoUrl());
        aulaExistente.setOrdem(novaAula.getOrdem());

        return aulasRepository.save(aulaExistente);

    }

    public void deletarAula (Long id) {
        aulasRepository.deleteById(id);
    }

}
