package com.tIdadeConect.T_IdadeConect.Controler;

import com.tIdadeConect.T_IdadeConect.Entities.Usuarios;
import com.tIdadeConect.T_IdadeConect.Services.UsuarioServices;
import com.tIdadeConect.T_IdadeConect.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioServices usuarioServices;

    //Create
    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuarios usuarios) {
        try {
            Usuarios novoUsuario = usuarioServices.criarUsuario(usuarios);
            return ResponseEntity.ok(novoUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }



    //Read
    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios () {
        return ResponseEntity.ok(usuarioServices.buscaTodos());
    }

    //Read por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioServices.buscaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> atualizarUsuarios(
            @PathVariable Long id,
            @RequestBody Usuarios usuarioAlterado
    ) {
        Usuarios usuario = usuarioServices.atualizarUsuario(id, usuarioAlterado);
        return ResponseEntity.ok(usuario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioServices.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
