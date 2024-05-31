package com.ecommerce.tiendaInformatica.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Long id;
    private String nombreUsuario;
    private String contrasenia;
    private String correoElectronico;

    private Cliente cliente;


    public Usuario(Long id, String nombreUsuario, String contrasenia, String correoElectronico, Cliente cliente) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.cliente = cliente;
    }

}
