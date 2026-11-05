package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.MiembroEquipo;
import com.example.apifutbol.repository.MiembroEquipoRepository;
import com.example.apifutbol.service.MiembroEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public class MiembroEquipoServiceImpl implements MiembroEquipoService {
    @Autowired
    private MiembroEquipoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<MiembroEquipo> listarPorEquipo(Long idEquipo) {
        return repository.findByEquipo_IdEquipo(idEquipo);
    }

    @Transactional
    @Override
    public MiembroEquipo agregarJugadorAEquipo(MiembroEquipo miembro) {
        boolean yaExiste = repository.existsByEquipo_IdEquipoAndUsuario_IdUsuario(
                miembro.getEquipo().getIdEquipo(),
                miembro.getUsuario().getIdUsuario()
        );
        if (yaExiste) {
            throw new RuntimeException("El jugador ya forma parte de este equipo.");
        }
        return repository.save(miembro);
    }

    @Transactional
    @Override
    public MiembroEquipo actualizarCoordenadas(Long idMiembro, BigDecimal coordX, BigDecimal coordY) {
        MiembroEquipo miembro = repository.findById(idMiembro)
                .orElseThrow(() -> new RuntimeException("Miembro de equipo no encontrado con ID: " + idMiembro));

        miembro.setCoordX(coordX);
        miembro.setCoordY(coordY);
        return repository.save(miembro);
    }

    @Transactional
    @Override
    public void eliminarMiembro(Long idMiembro) {
        MiembroEquipo miembro = repository.findById(idMiembro)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado con ID: " + idMiembro));
        repository.delete(miembro);
    }
}
