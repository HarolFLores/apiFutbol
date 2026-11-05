package com.example.apifutbol.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 5, nullable = false)
    private String adverviatura;

    @Column(length = 500, nullable = false)
    private String escudoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCapitan", nullable = false)
    private Usuario capitan;

    @Column(name = "formacionPredeterminada", length = 20)
    private String formacionPredeterminada = "1-2-2-1";

    @Column(name = "puntosRankingEquipo")
    private Integer puntosRankingEquipo = 1000;

    @Column(name = "partidosGanados")
    private Integer partidosGanados = 0;

    @Column(name = "partidosEmpatados")
    private Integer partidosEmpatados = 0;

    @Column(name = "partidosPerdidos")
    private Integer partidosPerdidos = 0;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MiembroEquipo> miembros = new HashSet<>();
}
