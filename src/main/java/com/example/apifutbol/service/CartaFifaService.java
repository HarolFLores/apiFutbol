package com.example.apifutbol.service;

import com.example.apifutbol.entity.CartaFifa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartaFifaService {
    Page<CartaFifa> findAll(Pageable pageable);
    CartaFifa findById(Long id);
    CartaFifa findByUsuarioId(Long idUsuario);
    CartaFifa create(CartaFifa obj);
    CartaFifa update(Long id, CartaFifa obj);
    void delete(Long id);
}