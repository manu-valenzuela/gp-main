package com.gp.contratosPersonal.repository;

import com.gp.contratosPersonal.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    // Métodos adicionales si necesitas búsquedas específicas
}
