package com.senai.exercicioUsuario.repositories;

import com.senai.exercicioUsuario.Models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
