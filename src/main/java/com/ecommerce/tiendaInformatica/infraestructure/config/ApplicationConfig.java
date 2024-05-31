package com.ecommerce.tiendaInformatica.infraestructure.config;

import com.ecommerce.tiendaInformatica.application.service.ClienteService;
import com.ecommerce.tiendaInformatica.application.service.UsuarioService;
import com.ecommerce.tiendaInformatica.application.usecase.ClienteUseCaseImpl;
import com.ecommerce.tiendaInformatica.application.usecase.UsuarioUseCaseImpl;
import com.ecommerce.tiendaInformatica.domain.ports.out.ClienteRepositoryPort;
import com.ecommerce.tiendaInformatica.domain.ports.out.UsuarioReposityPort;
import com.ecommerce.tiendaInformatica.infraestructure.mapper.ClienteMapper;
import com.ecommerce.tiendaInformatica.infraestructure.mapper.UsuarioMapper;
import com.ecommerce.tiendaInformatica.infraestructure.repository.ClienteJpaRepositoryAdapter;
import com.ecommerce.tiendaInformatica.infraestructure.repository.UsuarioJpaRepositoryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClienteService clienteService(ClienteRepositoryPort clienteRepositoryPort){
        return new ClienteService(new ClienteUseCaseImpl(clienteRepositoryPort));
    }
    @Bean
    public ClienteRepositoryPort clienteRepositoryPort(ClienteJpaRepositoryAdapter clienteJpaRepositoryAdapter){
        return clienteJpaRepositoryAdapter;
    }

    @Bean
    public UsuarioService usuarioService(UsuarioReposityPort usuarioReposityPort){
        return new UsuarioService(new UsuarioUseCaseImpl(usuarioReposityPort));
    }


    @Bean
    public UsuarioReposityPort usuarioReposityPort(UsuarioJpaRepositoryAdapter usuarioJpaRepositoryAdapter){
        return usuarioJpaRepositoryAdapter;
    }

}
