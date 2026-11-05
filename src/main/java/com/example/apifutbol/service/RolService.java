package com.example.apifutbol.service;

import com.example.apifutbol.entity.Rol;
import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Rol findById(Integer id);
    Optional<Rol> findByNombre(String nombre);
    Rol create(Rol rol);
    Rol update(Integer id, Rol rol);
    void delete(Integer id);
}
