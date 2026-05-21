package com.gp.registroFaenas.repository;

import com.gp.registroFaenas.model.Faena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaenaRepository extends JpaRepository<Faena, Integer> {
    // JpaRepository ya nos da: save(), findAll(), findById(), deleteById()
}
