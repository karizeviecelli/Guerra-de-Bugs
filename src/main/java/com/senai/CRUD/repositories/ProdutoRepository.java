package com.senai.CRUD.repositories;

import com.senai.CRUD.models.CategoriaModel;
import com.senai.CRUD.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
    List<ProdutoModel>findByCategoriaId_Id(Long categoriaId);
}
