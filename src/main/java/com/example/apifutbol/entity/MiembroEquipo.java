package com.example.apifutbol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "miembrosEquipo", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"idEquipo", "idUsuario"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MiembroEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMiembro")
    private Long idMiembro;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEquipo", nullable = false)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "rolEquipo", length = 20)
    private RolEnEquipo rolEnEquip = RolEnEquipo.TITULAR;

    private Integer dorsal;

    @Column(name = "coordX", precision = 5, scale = 4)
    private BigDecimal coordX = new BigDecimal("0.5000");

    @Column(name = "coordY", precision = 5, scale = 4)
    private BigDecimal coordY = new BigDecimal("0.5000");

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoMembresia", length = 20)
    private EstadoMembresia estadoMembresia = EstadoMembresia.ACTIVO;

    @Column(name = "fechaIngreso")
    private LocalDateTime fechaIngreso = LocalDateTime.now();

    public enum RolEnEquipo { CAPITAN, SUBCAPITAN, TITULAR, SUPLENTE }
    public enum EstadoMembresia { PENDIENTE, ACTIVO, INACTIVO }
}
