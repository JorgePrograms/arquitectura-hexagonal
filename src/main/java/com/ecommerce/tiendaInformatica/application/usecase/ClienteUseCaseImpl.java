package com.ecommerce.tiendaInformatica.application.usecase;

import com.ecommerce.tiendaInformatica.domain.model.Cliente;
import com.ecommerce.tiendaInformatica.domain.ports.in.ClienteUseCase;
import com.ecommerce.tiendaInformatica.domain.ports.out.ClienteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }



    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositoryPort.save(cliente);
    }
    @Override
    public Optional<Cliente> getCliente(Long id) {
        return clienteRepositoryPort.findById(id);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepositoryPort.findAll();
    }

    @Override
    public Optional updateCliente(Long id, Cliente cliente) {
        return clienteRepositoryPort.update(id, cliente);
    }

    @Override
    public boolean deleteCliente(Long id) {
        return clienteRepositoryPort.deleteById(id);
    }



}