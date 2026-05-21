package com.gp.registroSeguroCesantia.repository;

import com.gp.registroSeguroCesantia.model.SeguroCesantia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroCesantiaRepository extends JpaRepository<SeguroCesantia, Integer> {
}