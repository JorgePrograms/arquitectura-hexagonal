package com.ecommerce.tiendaInformatica.infraestructure.dto;

import com.ecommerce.tiendaInformatica.domain.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String correoElectronico;
    private Cliente cliente;

    public UsuarioDTO(Long id, String nombreUsuario, String correoElectronico, Cliente cliente) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.cliente = cliente;
    }


}
