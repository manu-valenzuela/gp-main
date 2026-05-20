package com.gp.registroIndicadores.repository;

import com.gp.registroIndicadores.model.Afp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfpRepository extends JpaRepository<Afp, Integer> {
}
