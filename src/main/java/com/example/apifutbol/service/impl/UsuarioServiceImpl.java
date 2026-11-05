package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.CartaFifa;
import com.example.apifutbol.entity.Usuario;
import com.example.apifutbol.repository.UsuarioRepository;
import com.example.apifutbol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository userRepo;

    @Transactional(readOnly = true)
    @Override
    public Page<Usuario> findAll(Pageable pageable, String search) {
        return userRepo.findAllWithSearch(search, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Transactional
    @Override
    public Usuario crear(Usuario obj) {
        if(userRepo.existsByEmail(obj.getEmail())) {
            throw new UnsupportedOperationException("EL CORREO YA ESTA REGISTRADO");
        }
        if(userRepo.existsByEmail(obj.getDni())) {
            throw new UnsupportedOperationException("EL DNI YA ESTA REGISTRADO");
        }
        if(obj.getCartaFifa() == null){
            CartaFifa cartaFifa = CartaFifa.builder().usuario(obj).mediaOvr(60)
                    .ritmoPac(60).tiroSho(60).pasePas(60).regateDri(60).defensaDef(60)
                    .fisicoPhy(60).tipoCarta(CartaFifa.TipoCarta.BRONCE).build();
            obj.setCartaFifa(cartaFifa);
        }
        return userRepo.save(obj);
    }

    @Transactional
    @Override
    public Usuario update(Long id, Usuario obj) {
        Usuario update = this.findById(id);
        update.setNombres(obj.getNombres());
        update.setApellidos(obj.getApellidos());
        update.setDni(obj.getDni());
        update.setEmail(obj.getEmail());
        update.setFotoPerfil(obj.getFotoPerfil());
        update.setEstado(obj.getEstado());
        return userRepo.save(update);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Usuario deleted = this.findById(id);
        deleted.setEstado(Usuario.EstadoUsuario.ELIMINADO);
        userRepo.save(deleted);
    }
}
