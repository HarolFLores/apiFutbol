package com.example.apifutbol.service;

import com.example.apifutbol.entity.PerfilJugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PerfilJugadorService {
    Page<PerfilJugador> findAllRanking(Pageable pageable);
    PerfilJugador findByIdUsuario(Long idUsuario);
    PerfilJugador update(Long idUsuario, PerfilJugador obj);
}
