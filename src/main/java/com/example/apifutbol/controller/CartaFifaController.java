package com.example.apifutbol.controller;

import com.example.apifutbol.entity.CartaFifa;
import com.example.apifutbol.service.impl.CartaFifaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartas-fifa")
@CrossOrigin(origins = "*")
public class CartaFifaController {

    @Autowired
    private CartaFifaServiceImpl service;

    @GetMapping
    public ResponseEntity<Page<CartaFifa>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaFifa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<CartaFifa> findByUsuarioId(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(service.findByUsuarioId(idUsuario));
    }

    @PostMapping
    public ResponseEntity<CartaFifa> create(@RequestBody CartaFifa obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaFifa> update(@PathVariable Long id, @RequestBody CartaFifa obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}