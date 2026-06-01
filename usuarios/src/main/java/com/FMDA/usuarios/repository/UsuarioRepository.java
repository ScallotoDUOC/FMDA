package com.FMDA.usuarios.repository;

import com.FMDA.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    // login / búsqueda principal
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByUsernameAndPassword(
            String username,
            String password
    );

    // validaciones
    boolean existsById(Long id);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    // filtros
    List<Usuario> findByActivo(boolean activo);

    List<Usuario> findByRol(String rol);

    // partida
    List<Usuario> findAllByPartidaName(String partidaName);

    boolean existsByPartidaName(String partidaName);
}