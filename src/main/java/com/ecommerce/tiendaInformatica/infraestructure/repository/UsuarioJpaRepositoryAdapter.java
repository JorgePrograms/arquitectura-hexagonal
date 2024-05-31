package com.ecommerce.tiendaInformatica.infraestructure.repository;

import com.ecommerce.tiendaInformatica.domain.model.Usuario;
import com.ecommerce.tiendaInformatica.domain.ports.out.UsuarioReposityPort;
import com.ecommerce.tiendaInformatica.infraestructure.entity.UsuarioEntity;
import com.ecommerce.tiendaInformatica.infraestructure.mapper.UsuarioMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioJpaRepositoryAdapter implements UsuarioReposityPort {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioMapper usuarioMapper;


    public UsuarioJpaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository,
                                       UsuarioMapper usuarioMapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioMapper = usuarioMapper;

    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity=usuarioMapper.toUsuarioEntity(usuario);
        UsuarioEntity saveUsuarioEntity=usuarioJpaRepository.save(usuarioEntity);
        return usuarioMapper.toUsuario(saveUsuarioEntity);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioJpaRepository.findById(id).map(usuarioMapper::toUsuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioJpaRepository.findAll().stream().
                map(usuarioMapper::toUsuario).collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if(usuarioJpaRepository.existsById(id)){
            UsuarioEntity usuarioEntity=usuarioMapper.toUsuarioEntity(usuario);
            usuarioEntity.setId(id);
            UsuarioEntity updateUsuarioEntity=usuarioJpaRepository.save(usuarioEntity);
            Usuario updateUsuario=usuarioMapper.toUsuario(updateUsuarioEntity);
            return Optional.of(updateUsuario);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(usuarioJpaRepository.existsById(id)){
            usuarioJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
