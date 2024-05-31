package com.ecommerce.tiendaInformatica.domain.ports.out;

import com.ecommerce.tiendaInformatica.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioReposityPort {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    Optional<Usuario> update(Long id, Usuario usuario);
    boolean deleteById(Long id);
}
