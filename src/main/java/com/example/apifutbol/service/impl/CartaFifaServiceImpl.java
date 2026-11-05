package com.example.apifutbol.service.impl;

import com.example.apifutbol.entity.CartaFifa;
import com.example.apifutbol.repository.CartaFifaRepository;
import com.example.apifutbol.service.CartaFifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CartaFifaServiceImpl implements CartaFifaService {
    @Autowired
    private CartaFifaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<CartaFifa> findAll(Pageable pageable) {
        return repository.findAllSortedByOvr(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public CartaFifa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carta FIFA no encontrada con ID: " + id));
    }

    @Transactional(readOnly = true)
    @Override
    public CartaFifa findByUsuarioId(Long idUsuario) {
        return repository.findByUsuario_IdUsuario(idUsuario)
                .orElseThrow(() -> new RuntimeException("El usuario con ID " + idUsuario + " no tiene una Carta FIFA asociada."));
    }

    @Transactional
    @Override
    public CartaFifa create(CartaFifa obj) {
        obj.setUltimaActualizacion(LocalDateTime.now());
        return repository.save(obj);
    }

    @Transactional
    @Override
    public CartaFifa update(Long id, CartaFifa obj) {
        CartaFifa cartaExistente = this.findById(id);

        cartaExistente.setMediaOvr(obj.getMediaOvr());
        cartaExistente.setRitmoPac(obj.getRitmoPac());
        cartaExistente.setTiroSho(obj.getTiroSho());
        cartaExistente.setPasePas(obj.getPasePas());
        cartaExistente.setRegateDri(obj.getRegateDri());
        cartaExistente.setDefensaDef(obj.getDefensaDef());
        cartaExistente.setFisicoPhy(obj.getFisicoPhy());
        cartaExistente.setTipoCarta(obj.getTipoCarta());
        cartaExistente.setUltimaActualizacion(LocalDateTime.now());

        return repository.save(cartaExistente);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        CartaFifa carta = this.findById(id);
        repository.delete(carta);
    }
}