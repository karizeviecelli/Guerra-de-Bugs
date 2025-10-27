package com.senai.CRUD.services;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.CategoriaRequestDto;
import com.senai.CRUD.exceptions.CategoriaEmUsoException;
import com.senai.CRUD.exceptions.CategoriaExistenteException;
import com.senai.CRUD.models.CategoriaModel;
import com.senai.CRUD.models.ProdutoModel;
import com.senai.CRUD.repositories.CategoriaRepository;
import com.senai.CRUD.repositories.ProdutoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    public CategoriaService(CategoriaRepository categoriaRepository,ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public boolean cadastrarCategoria(CategoriaRequestDto dados){
        CategoriaModel c= new CategoriaModel();
        List<CategoriaReponseDto>categoriasDTO = listar();

        for (CategoriaReponseDto categoria : categoriasDTO){
            if(categoria.getNome().equals(dados.getNome())){
                throw new CategoriaExistenteException();
            }
        }
        c.setNome(dados.getNome());
        categoriaRepository.save(c);
        return true;

    }

    public List<CategoriaReponseDto> listar(){
        List<CategoriaModel> categoriasModel = categoriaRepository.findAll();

        List<CategoriaReponseDto> categoriasDto = new ArrayList<>();
        for(CategoriaModel c : categoriasModel){
            categoriasDto.add(new CategoriaReponseDto(c));
        }
        return categoriasDto;
    }

    public CategoriaReponseDto buscarCategoria(Long id){
        CategoriaModel categoriaModel = categoriaRepository.findById(id).get();
        return new CategoriaReponseDto(categoriaModel);
    }

    public boolean atualizarCategoria(CategoriaRequestDto dados,long id){
        CategoriaModel c = categoriaRepository.findById(id).get();
        List<CategoriaReponseDto>categoriasDTO = listar();

        for (CategoriaReponseDto categoria : categoriasDTO){
            if(categoria.getNome().equals(dados.getNome()) && categoria.getId() != id){
                throw new CategoriaExistenteException();
            }
        }
        c.setNome(dados.getNome());
        categoriaRepository.save(c);
        return true;

    }

    public boolean deletarCategoria(long id){
       List<ProdutoModel> produtos = produtoRepository.findByCategoriaId_Id(id);
       if (produtos.size() > 0){
          throw new CategoriaEmUsoException();
       }
        categoriaRepository.deleteById(id);
       return true;

    }


}
