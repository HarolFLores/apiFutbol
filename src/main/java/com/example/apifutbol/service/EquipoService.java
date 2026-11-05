package com.example.apifutbol.service;

import com.example.apifutbol.entity.Equipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EquipoService {
    Page<Equipo> findAll(Pageable pageable, String search);
    Equipo findById(Long id);
    Equipo create(Equipo obj);
    Equipo update(Long id, Equipo obj);
    void delete(Long id);
}
