package com.ecommerce.tiendaInformatica.infraestructure.repository;

import com.ecommerce.tiendaInformatica.infraestructure.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity,Long> {
}
