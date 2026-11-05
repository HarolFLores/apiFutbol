package com.example.apifutbol.controller;

import com.example.apifutbol.entity.Usuario;
import com.example.apifutbol.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl userSerImpl;

    @GetMapping
    public ResponseEntity<Page<Usuario>> findAll(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(userSerImpl.findAll(pageable, search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userSerImpl.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(userSerImpl.crear(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
        return ResponseEntity.ok(userSerImpl.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userSerImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}
