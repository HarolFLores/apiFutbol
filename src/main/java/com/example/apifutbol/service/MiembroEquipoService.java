package com.example.apifutbol.service;

import com.example.apifutbol.entity.MiembroEquipo;
import java.math.BigDecimal;
import java.util.List;

public interface MiembroEquipoService {
    List<MiembroEquipo> listarPorEquipo(Long idEquipo);
    MiembroEquipo agregarJugadorAEquipo(MiembroEquipo miembro);
    MiembroEquipo actualizarCoordenadas(Long idMiembro, BigDecimal coordX, BigDecimal coordY);
    void eliminarMiembro(Long idMiembro);
}
