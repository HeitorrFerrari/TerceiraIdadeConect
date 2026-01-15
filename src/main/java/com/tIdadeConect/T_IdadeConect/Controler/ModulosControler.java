package com.tIdadeConect.T_IdadeConect.Controler;

import com.tIdadeConect.T_IdadeConect.Entities.Modulos;
import com.tIdadeConect.T_IdadeConect.Services.ModulosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModulosControler {

    @Autowired
    private ModulosServices modulosServices;

    @PostMapping
    public ResponseEntity<?> criarModulo(@RequestBody Modulos modulos) {
        try {
            Modulos novoModulo = modulosServices.criarModulo(modulos);
            return ResponseEntity.ok(novoModulo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Modulos>> listarModulos() {
        return ResponseEntity.ok(modulosServices.listarModulos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulos> listarModuloId(@PathVariable Long id) {
        return modulosServices.listarModuloId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulos> atualizarModulos(
            @PathVariable Long id,
            @RequestBody Modulos moduloAtualizado
    ) {
        Modulos modulo = modulosServices.atualizarModulos(id, moduloAtualizado);
        return ResponseEntity.ok(modulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarModulo(@PathVariable Long id) {
        modulosServices.deletarModulo(id);
        return ResponseEntity.noContent().build();
    }

}