package com.ecommerce.tiendaInformatica.application.usecase;


import com.ecommerce.tiendaInformatica.domain.model.Usuario;
import com.ecommerce.tiendaInformatica.domain.ports.in.UsuarioUseCase;
import com.ecommerce.tiendaInformatica.domain.ports.out.UsuarioReposityPort;

import java.util.List;
import java.util.Optional;

public class UsuarioUseCaseImpl implements UsuarioUseCase {

private final UsuarioReposityPort usuarioReposityPort;

    public UsuarioUseCaseImpl(UsuarioReposityPort usuarioReposityPort) {
        this.usuarioReposityPort = usuarioReposityPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioReposityPort.save(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioReposityPort.findById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioReposityPort.findAll();
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
        return usuarioReposityPort.update(id,usuario);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return usuarioReposityPort.deleteById(id);
    }
}
