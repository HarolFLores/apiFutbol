package com.example.apifutbol.controller;

import com.example.apifutbol.entity.PerfilJugador;
import com.example.apifutbol.service.impl.PerfilJugadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles-jugador")
@CrossOrigin(origins = "*")
public class PerfilJugadorController {
    @Autowired
    private PerfilJugadorServiceImpl service;

    @GetMapping("/ranking")
    public ResponseEntity<Page<PerfilJugador>> getRanking(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(service.findAllRanking(pageable));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<PerfilJugador> findByIdUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(service.findByIdUsuario(idUsuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<PerfilJugador> update(@PathVariable Long idUsuario, @RequestBody PerfilJugador obj) {
        return ResponseEntity.ok(service.update(idUsuario, obj));
    }
}
