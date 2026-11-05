package com.example.apifutbol.service;

import com.example.apifutbol.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {
    Page<Usuario> findAll(Pageable pageable, String search);
    Usuario findById(Long id);
    Usuario crear(Usuario obj);
    Usuario update(Long id, Usuario obj);
    void delete(Long id);
}
