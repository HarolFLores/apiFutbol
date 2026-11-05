package com.example.apifutbol.repository;

import com.example.apifutbol.entity.PerfilJugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerfilJugadorRepository extends JpaRepository<PerfilJugador, Long> {
    @Query("SELECT p FROM PerfilJugador p ORDER BY p.puntosRanking DESC")
    Page<PerfilJugador> findAllSortedByRanking(Pageable pageable);
}
