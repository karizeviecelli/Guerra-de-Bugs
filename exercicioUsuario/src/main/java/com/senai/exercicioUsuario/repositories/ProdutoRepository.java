package com.senai.exercicioUsuario.repositories;

import com.senai.exercicioUsuario.Dtos.ProdutoDto;
import com.senai.exercicioUsuario.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
