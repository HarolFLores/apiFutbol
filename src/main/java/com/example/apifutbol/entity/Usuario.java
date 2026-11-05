package com.example.apifutbol.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(length = 8, nullable = false, unique = true)
    private String dni;

    @Column(length = 9, nullable = false, unique = true)
    private String telefono;

    @Column(length = 120, unique = true, nullable = false)
    private String email;

    @Column(name = "passwordHash", nullable = false)
    private String passwordHash;

    @Column(name = "fotoPerfil", nullable = true)
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstadoUsuario estado = EstadoUsuario.ACTIVO;

    @Column(name = "fechaRegistro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarioRol",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol")
    )
    private Set<Rol> roles = new HashSet<>();

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PerfilJugador perfilJugador;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private CartaFifa cartaFifa;

    public enum EstadoUsuario {ACTIVO, SUSPENDIDO, ELIMINADO}
}