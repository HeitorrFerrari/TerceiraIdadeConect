package com.tIdadeConect.T_IdadeConect.repositories;


import com.tIdadeConect.T_IdadeConect.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
