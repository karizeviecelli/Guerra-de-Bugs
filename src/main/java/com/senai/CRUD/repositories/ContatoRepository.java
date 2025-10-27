package com.senai.CRUD.repositories;

import com.senai.CRUD.models.ContatoModel;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel,Long> {
    Optional<ContatoModel> findByEmail(String email);

}

