package com.example.apifutbol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cartaFifa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartaFifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarta")
    private Long idCarta;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "mediaOvr", nullable = false)
    private Integer mediaOvr = 60;

    @Column(name = "ritmoPac", nullable = false)
    private Integer ritmoPac = 60;

    @Column(name = "tiroSho", nullable = false)
    private Integer tiroSho = 60;

    @Column(name = "pasePas", nullable = false)
    private Integer pasePas = 60;

    @Column(name = "regateDri", nullable = false)
    private Integer regateDri = 60;

    @Column(name = "defensaDef", nullable = false)
    private Integer defensaDef = 60;

    @Column(name = "fisicoPhy", nullable = false)
    private Integer fisicoPhy = 60;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCarta")
    private TipoCarta tipoCarta = TipoCarta.BRONCE;

    @Column(name = "ultimaActualizacion")
    private LocalDateTime ultimaActualizacion = LocalDateTime.now();

    public enum TipoCarta { BRONCE, PLATA, ORO, IF_TOTW, LEYENDA }
}
