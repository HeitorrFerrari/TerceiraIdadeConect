package com.tIdadeConect.T_IdadeConect.Services;

import com.tIdadeConect.T_IdadeConect.Entities.Usuarios;
import com.tIdadeConect.T_IdadeConect.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Criando um usuario
    public Usuarios criarUsuario (Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    // Lista todos os usuarios
    public List<Usuarios> buscaTodos() {
        return usuariosRepository.findAll();
    }

    //Lista usuario por ID
    public Optional<Usuarios> buscaPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios atualizarUsuario(Long id, Usuarios novoUsuario) {

        Usuarios usuarioExistente = usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(novoUsuario.getNome());
        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setSenha(novoUsuario.getSenha());

        return usuariosRepository.save(usuarioExistente);
    }

    // Deletar
    public void deletarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }


}
