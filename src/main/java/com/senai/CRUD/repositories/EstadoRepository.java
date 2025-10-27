package com.senai.CRUD.repositories;

import com.senai.CRUD.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<EstadoModel,Long> {
    Optional<EstadoModel> findByNome(String nome);
}
