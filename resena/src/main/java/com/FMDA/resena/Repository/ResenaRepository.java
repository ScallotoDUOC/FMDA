package com.FMDA.resena.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.FMDA.resena.Model.Resena;

@Repository
public class ResenaRepository {

    private final ConcurrentHashMap<Long, Resena> recenas = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    // Guarda una reseña nueva o actualiza una existente
    public Resena save(Resena resena) {

        // Si la reseña no tiene ID, genera uno automáticamente
        if (resena.getId() == null) {
            resena.setId(idGenerator.getAndIncrement());
        }
        // Guarda la reseña en la colección usando el ID como clave
        recenas.put(resena.getId(), resena);
        return resena;
    }

    // Obtiene todas las reseñas almacenadas
    public List<Resena> findAll() {
        return new ArrayList<>(recenas.values());
    }

    // Busca una reseña por su ID
    public Resena findById(Long id) {
        return recenas.get(id);
    }

    // Elimina una reseña según su ID
    public void deleteById(Long id) {
        recenas.remove(id);
    }

    // Verifica si una reseña existe por ID
    public boolean existsById(Long id) {
        return recenas.containsKey(id);
    }

    // Actualiza una reseña existente
    public Resena update(Resena resena) {
        if (resena.getId() == null || !recenas.containsKey(resena.getId())) {
            throw new IllegalArgumentException("Resena con ID " + resena.getId() + " no existe.");
        }
        recenas.put(resena.getId(), resena);
        return resena;
    }

    // Busca una reseña por nombre de usuario
    public Resena findByUsuario(String usuario) {
        return recenas.values().stream()
                .filter(r -> r.getUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .orElse(null);
    }
}