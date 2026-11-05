package com.example.apifutbol.repository;

import com.example.apifutbol.entity.MiembroEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MiembroEquipoRepository extends JpaRepository<MiembroEquipo, Long> {
    List<MiembroEquipo> findByEquipo_IdEquipo(Long idEquipo);
    boolean existsByEquipo_IdEquipoAndUsuario_IdUsuario(Long idEquipo, Long idUsuario);
}
