package com.ecommerce.tiendaInformatica.infraestructure.mapper;

import com.ecommerce.tiendaInformatica.domain.model.Usuario;
import com.ecommerce.tiendaInformatica.infraestructure.dto.UsuarioDTO;
import com.ecommerce.tiendaInformatica.infraestructure.entity.UsuarioEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses=ClienteMapper.class)
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "clienteEntity", target = "cliente"),
            @Mapping(target = "contrasenia", ignore = true)
    })
    Usuario toUsuario(UsuarioEntity usuarioEntity);

    @Mappings({
            @Mapping(source = "cliente", target = "clienteEntity")
    })
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    @Mappings({
            @Mapping(source = "cliente", target = "cliente")
    })
    UsuarioDTO toUsuarioDTO(Usuario usuario);

}
