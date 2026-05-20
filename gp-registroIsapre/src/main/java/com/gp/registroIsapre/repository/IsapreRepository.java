package com.gp.registroIsapre.repository;

import com.gp.registroIsapre.model.Isapre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsapreRepository extends JpaRepository<Isapre, Integer> {
}
