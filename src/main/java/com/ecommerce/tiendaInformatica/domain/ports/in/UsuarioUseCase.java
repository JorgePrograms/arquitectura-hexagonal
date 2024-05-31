package com.ecommerce.tiendaInformatica.domain.ports.in;

import com.ecommerce.tiendaInformatica.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioUseCase {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuario(Long id);
    Optional<Usuario> updateUsuario(Long id,Usuario usuario);
    boolean deleteUsuario(Long id);
}
