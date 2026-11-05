package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.PerfilJugador;
import com.example.apifutbol.repository.PerfilJugadorRepository;
import com.example.apifutbol.service.PerfilJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class PerfilJugadorServiceImpl implements PerfilJugadorService {
    @Autowired
    private PerfilJugadorRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<PerfilJugador> findAllRanking(Pageable pageable) {
        return repository.findAllSortedByRanking(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public PerfilJugador findByIdUsuario(Long idUsuario) {
        return repository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Perfil de jugador no encontrado para el ID: " + idUsuario));
    }

    @Transactional
    @Override
    public PerfilJugador update(Long idUsuario, PerfilJugador obj) {
        PerfilJugador perfil = this.findByIdUsuario(idUsuario);
        perfil.setApodo(obj.getApodo());
        perfil.setPosicionPrincipal(obj.getPosicionPrincipal());
        perfil.setPiernaHabil(obj.getPiernaHabil());
        perfil.setAlturaCm(obj.getAlturaCm());
        perfil.setPesoKg(obj.getPesoKg());
        perfil.setFechaNacimiento(obj.getFechaNacimiento());
        return repository.save(perfil);
    }
}
