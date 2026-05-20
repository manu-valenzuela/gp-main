package com.gp.registroAfp.repository;

import com.gp.registroAfp.model.Afp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfpRepository extends JpaRepository<Afp, Integer> {
}
