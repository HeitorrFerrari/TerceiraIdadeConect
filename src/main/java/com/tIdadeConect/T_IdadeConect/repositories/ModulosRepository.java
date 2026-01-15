package com.tIdadeConect.T_IdadeConect.repositories;


import com.tIdadeConect.T_IdadeConect.Entities.Modulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulosRepository extends JpaRepository<Modulos, Long> {

}
