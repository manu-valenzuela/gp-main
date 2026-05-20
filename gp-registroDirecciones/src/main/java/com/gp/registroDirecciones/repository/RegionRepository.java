package com.gp.registroDirecciones.repository;

import com.gp.registroDirecciones.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
