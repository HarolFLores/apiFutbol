package com.example.apifutbol.repository;

import com.example.apifutbol.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByDni (String dni);
    @Query("SELECT u FROM Usuario u WHERE :search IS NULL OR " +
            "LOWER(u.nombres) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(u.apellidos) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Usuario> findAllWithSearch(@Param("search") String search, Pageable pageable);
}
