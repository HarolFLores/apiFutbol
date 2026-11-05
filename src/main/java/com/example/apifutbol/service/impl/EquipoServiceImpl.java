package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.Equipo;
import com.example.apifutbol.repository.EquipoRepository;
import com.example.apifutbol.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<Equipo> findAll(Pageable pageable, String search) {
        return repository.findAllWithSearch(search, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Equipo findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    @Transactional
    @Override
    public Equipo create(Equipo obj) {
        return repository.save(obj);
    }

    @Transactional
    @Override
    public Equipo update(Long id, Equipo obj) {
        Equipo update = this.findById(id);
        update.setNombre(obj.getNombre());
        update.setAdverviatura(obj.getAdverviatura());
        update.setEscudoUrl(obj.getEscudoUrl());
        update.setFormacionPredeterminada(obj.getFormacionPredeterminada());
        return repository.save(update);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Equipo equipo = this.findById(id);
        repository.delete(equipo);
    }
}