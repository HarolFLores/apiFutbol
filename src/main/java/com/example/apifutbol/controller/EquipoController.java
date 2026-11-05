package com.example.apifutbol.controller;

import com.example.apifutbol.entity.Equipo;
import com.example.apifutbol.service.impl.EquipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    @Autowired
    private EquipoServiceImpl service;

    @GetMapping
    public ResponseEntity<Page<Equipo>> findAll(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(service.findAll(pageable, search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Equipo> create(@RequestBody Equipo obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> update(@PathVariable Long id, @RequestBody Equipo obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}