package com.ecommerce.tiendaInformatica.infraestructure.mapper;

import com.ecommerce.tiendaInformatica.domain.model.Cliente;
import com.ecommerce.tiendaInformatica.infraestructure.entity.ClienteEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(Cliente cliente);

}
