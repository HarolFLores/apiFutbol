package com.example.apifutbol.controller;

import com.example.apifutbol.entity.MiembroEquipo;
import com.example.apifutbol.service.impl.MiembroEquipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/miembros-equipo")
@CrossOrigin(origins = "*")
public class MiembroEquipoController {

    @Autowired
    private MiembroEquipoServiceImpl service;

    @GetMapping("/equipo/{idEquipo}")
    public ResponseEntity<List<MiembroEquipo>> listarPorEquipo(@PathVariable Long idEquipo) {
        return ResponseEntity.ok(service.listarPorEquipo(idEquipo));
    }

    @PostMapping
    public ResponseEntity<MiembroEquipo> agregar(@RequestBody MiembroEquipo miembro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agregarJugadorAEquipo(miembro));
    }

    @PatchMapping("/{id}/coordenadas")
    public ResponseEntity<MiembroEquipo> actualizarCoordenadas(
            @PathVariable Long id,
            @RequestParam BigDecimal coordX,
            @RequestParam BigDecimal coordY) {
        return ResponseEntity.ok(service.actualizarCoordenadas(id, coordX, coordY));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarMiembro(id);
        return ResponseEntity.noContent().build();
    }
}