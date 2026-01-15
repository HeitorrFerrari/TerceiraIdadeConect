package com.tIdadeConect.T_IdadeConect.repositories;

import com.tIdadeConect.T_IdadeConect.Entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {

}
