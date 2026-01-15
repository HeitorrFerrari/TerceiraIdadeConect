package com.tIdadeConect.T_IdadeConect.repositories;
import com.tIdadeConect.T_IdadeConect.Entities.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulasRepository extends JpaRepository<Aulas, Long> {

}
