package com.tIdadeConect.T_IdadeConect.Controler;


import com.tIdadeConect.T_IdadeConect.Entities.Cursos;
import com.tIdadeConect.T_IdadeConect.Services.CursosServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursosControler {

    @Autowired
    private CursosServices cursosServices;

    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody Cursos cursos) {
        try {
            Cursos novoCurso = cursosServices.criarCurso(cursos);
            return ResponseEntity.ok(novoCurso);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cursos>> listarCursos () {
        return ResponseEntity.ok(cursosServices.buscarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> buscaCursoPorId (@PathVariable Long id) {
        return cursosServices.buscarUnicoCurso(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> atualizarCurso (
            @PathVariable Long id,
            @RequestBody Cursos cursoAtualizado
    ) {
        Cursos cursos = cursosServices.atualizarCurso(id, cursoAtualizado);
        return ResponseEntity.ok(cursos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso (@PathVariable Long id) {
        cursosServices.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

}
