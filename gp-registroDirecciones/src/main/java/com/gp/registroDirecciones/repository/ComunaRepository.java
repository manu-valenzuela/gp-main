package com.gp.registroDirecciones.repository;

import com.gp.registroDirecciones.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}
