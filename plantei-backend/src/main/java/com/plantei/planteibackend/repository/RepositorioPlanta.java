package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPlanta extends JpaRepository<Planta, Long> {
}
