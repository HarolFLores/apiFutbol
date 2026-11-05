package com.example.apifutbol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "perfilesJugador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilJugador {
    @Id
    @Column(name = "idUsuario")
    private Long idUsuario;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(length = 50)
    private String apodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "posicionPrincipal", nullable = false, length = 10)
    private PosicionPrincipal posicionPrincipal;

    @Enumerated(EnumType.STRING)
    @Column(name = "piernaHabil", length = 20)
    private PiernaHabil piernaHabil = PiernaHabil.DERECHA;

    @Column(name = "alturaCm")
    private Integer alturaCm;

    @Column(name = "pesoKg", precision = 5, scale = 2)
    private BigDecimal pesoKg;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "partidosJugados")
    private Integer partidosJugados = 0;

    @Column(name = "golesTotales")
    private Integer golesTotales = 0;

    @Column(name = "asistenciasTotales")
    private Integer asistenciasTotales = 0;

    @Column(name = "mvpGanados")
    private Integer mvpGanados = 0;

    @Column(name = "puntosRanking")
    private Integer puntosRanking = 1000;

    public enum PosicionPrincipal { POR, DEF, MC, DEL }
    public enum PiernaHabil { DERECHA, IZQUIERDA, AMBIDIESTRO }
}
