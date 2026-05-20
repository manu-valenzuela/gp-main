package com.gp.registroIndicadores.repository;

import com.gp.registroIndicadores.model.SeguroCesantiaTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroCesantiaRepository extends JpaRepository<SeguroCesantiaTrabajador, Integer> {
}
