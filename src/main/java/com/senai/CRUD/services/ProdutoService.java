package com.senai.CRUD.services;

import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.ProdutoResponseDto;
import com.senai.CRUD.exceptions.CategoriaNotFoundException;
import com.senai.CRUD.exceptions.ProdutoNotFound;
import com.senai.CRUD.models.CategoriaModel;
import com.senai.CRUD.models.ProdutoModel;
import com.senai.CRUD.repositories.CategoriaRepository;
import com.senai.CRUD.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository repository,CategoriaRepository categoriaRepository) {
        this.produtoRepository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public boolean cadastroProduto(ProdutoRequestDto dados){
        ProdutoModel p = new ProdutoModel();
        List<CategoriaModel> categorias = categoriaRepository.findAll();

        for (CategoriaModel c : categorias){
            if(c.getId() == dados.getCategoriaId()){
                p.setNome(dados.getNome());
                p.setPreco(dados.getPreco());
                p.setCategoriaId(c);
                produtoRepository.save(p);

                return true;
            }
        }
        throw new CategoriaNotFoundException();

    }

    public List<ProdutoResponseDto> listarProdutos() {
        List<ProdutoModel>produtosModel = produtoRepository.findAll();

        List<CategoriaModel>categoria = categoriaRepository.findAll();

        List<ProdutoResponseDto> produtosDto = new ArrayList<>();

        for (ProdutoModel p : produtosModel) {
            for (CategoriaModel c : categoria) {
                if (p.getCategoriaId().getId() == c.getId()) {
                    produtosDto.add(new ProdutoResponseDto(p, c.getNome()));
                }
            }
        }
        return produtosDto;
    }

    public List<ProdutoResponseDto> listarProdutosPorCategoria(Long id) {
        List<ProdutoResponseDto>retorna = new ArrayList<>();
        List<ProdutoModel>produtos = produtoRepository.findByCategoriaId_Id(id);
        ProdutoResponseDto produto = new ProdutoResponseDto();
        if (produtos.isEmpty()){
            throw new ProdutoNotFound();
        }
        for (ProdutoModel p :produtos){
            retorna.add(new ProdutoResponseDto(p,p.getCategoriaId().getNome())) ;
        }
        return retorna;
    }
    public boolean atualizarProduto(ProdutoDto dados, Long id){
        ProdutoModel p = produtoRepository.findById(id).get();
        CategoriaModel c = categoriaRepository.findById(dados.getCategoria()).get();
        p.setId(id);
        p.setNome(dados.getNome());
        p.setPreco(dados.getPreco());
        p.setCategoriaId(c);
        produtoRepository.save(p);
        return true;

    }




    public ProdutoDto listarProdutobyId(long id){
        Optional<ProdutoModel> p = produtoRepository.findById(id);
        if (p.isPresent()) {

            ProdutoDto dto = new ProdutoDto();
            dto.setId(p.get().getId());
            dto.setNome(p.get().getNome());
            dto.setPreco(p.get().getPreco());
            dto.setCategoria(p.get().getCategoriaId().getId());
            return dto;
        }
        return null;
    }
    public boolean deletarProduto(long id){
        if (listarProdutobyId(id) != null){
            produtoRepository.deleteById(id);
            return true;
        }
        throw new ProdutoNotFound(id);
    }
}
