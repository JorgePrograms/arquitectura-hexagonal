package com.ecommerce.tiendaInformatica.infraestructure.repository;

import com.ecommerce.tiendaInformatica.infraestructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity,Long> {
}
