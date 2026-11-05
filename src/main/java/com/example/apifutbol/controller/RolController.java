package com.example.apifutbol.controller;

import com.example.apifutbol.entity.Rol;
import com.example.apifutbol.service.impl.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolController {
    @Autowired
    private RolServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Rol>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable Integer id, @RequestBody Rol rol) {
        return ResponseEntity.ok(service.update(id, rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
