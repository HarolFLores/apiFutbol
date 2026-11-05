package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.Rol;
import com.example.apifutbol.repository.RolRepository;
import com.example.apifutbol.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Rol findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Transactional
    @Override
    public Rol create(Rol rol) {
        if (repository.findByNombre(rol.getNombre()).isPresent()) {
            throw new RuntimeException("El rol con el nombre '" + rol.getNombre() + "' ya existe.");
        }
        return repository.save(rol);
    }

    @Transactional
    @Override
    public Rol update(Integer id, Rol rol) {
        Rol rolExistente = this.findById(id);
        rolExistente.setNombre(rol.getNombre());
        return repository.save(rolExistente);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Rol rol = this.findById(id);
        repository.delete(rol);
    }
}
