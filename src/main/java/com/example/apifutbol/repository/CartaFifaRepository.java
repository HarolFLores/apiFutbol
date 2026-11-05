package com.example.apifutbol.repository;

import com.example.apifutbol.entity.CartaFifa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartaFifaRepository extends JpaRepository<CartaFifa, Long> {
    Optional<CartaFifa> findByUsuario_IdUsuario(Long idUsuario);
    @Query("SELECT c FROM CartaFifa c ORDER BY c.mediaOvr DESC")
    Page<CartaFifa> findAllSortedByOvr(Pageable pageable);
}