package com.gp.registroIndicadores.repository;

import com.gp.registroIndicadores.model.Isapre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsapreRepository extends JpaRepository<Isapre, Integer> {
}
