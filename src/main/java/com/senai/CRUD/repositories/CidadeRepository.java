package com.senai.CRUD.repositories;

import com.senai.CRUD.models.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
    Optional<CidadeModel> findByNome(String nome);

}
