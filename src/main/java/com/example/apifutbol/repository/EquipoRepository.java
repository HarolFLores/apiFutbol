package com.example.apifutbol.repository;

import com.example.apifutbol.entity.Equipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    @Query("SELECT e FROM Equipo e WHERE :search IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Equipo> findAllWithSearch(@Param("search") String search, Pageable pageable);
}
