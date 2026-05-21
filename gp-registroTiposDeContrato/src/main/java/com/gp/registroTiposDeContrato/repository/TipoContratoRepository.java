package com.gp.registroTiposDeContrato.repository;

import com.gp.registroTiposDeContrato.model.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContratoRepository extends JpaRepository<TipoContrato, Integer> {
}
