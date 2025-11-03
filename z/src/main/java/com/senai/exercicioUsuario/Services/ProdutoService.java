package com.senai.exercicioUsuario.Services;

import com.senai.exercicioUsuario.Dtos.ListaProdutoDto;
import com.senai.exercicioUsuario.Dtos.ProdutoDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Models.CategoriaModel;
import com.senai.exercicioUsuario.Models.ProdutoModel;
import com.senai.exercicioUsuario.repositories.CategoriaRepository;
import com.senai.exercicioUsuario.repositories.ProdutoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    private final CategoriaRepository repositoryCategoria;

    public ProdutoService(ProdutoRepository repository, CategoriaRepository repositoryCategoria){
        this.repository = repository;
        this.repositoryCategoria = repositoryCategoria;
    }

    public void cadastrarProduto(ProdutoDto produto) {

        Optional<CategoriaModel> categoriaOP = repositoryCategoria.findById(produto.getCategoriaId());

        if (categoriaOP.isPresent()){

            ProdutoModel model = new ProdutoModel();

            model.setCategoria(categoriaOP.get());
            model.setNome(produto.getNome());
            model.setPreco(produto.getPreco());

            repository.save(model);
        }
    }

    public List<ProdutoDto> listarTodosProdutos(){

        List<ProdutoModel> listaProdutoOP = repository.findAll();

        List<ProdutoDto> listaDto = new ArrayList<>();

        for (int i = 0; i < listaProdutoOP.size(); i++) {

            ProdutoDto produto = new ProdutoDto();

            produto.setId(listaProdutoOP.get(i).getId());
            produto.setNome(listaProdutoOP.get(i).getNome());
            produto.setPreco(listaProdutoOP.get(i).getPreco());
            produto.setCategoriaId(listaProdutoOP.get(i).getCategoria().getId());

            listaDto.add(produto);
        }

        return listaDto;
    }

    public ProdutoDto retornaProduto(Long id){

        Optional <ProdutoModel> produtoOP = repository.findById(id);

        ProdutoDto dto = new ProdutoDto();

        if (produtoOP.isPresent()){

            dto.setId(produtoOP.get().getId());
            dto.setNome(produtoOP.get().getNome());
            dto.setPreco(produtoOP.get().getPreco());
            dto.setCategoriaId(produtoOP.get().getCategoria().getId());

            return dto;
        }
        return dto;
    }

    public RespostaDto deletarProduto(Long id){

        RespostaDto resposta = new RespostaDto();
        Optional <ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()){

            repository.deleteById(id);
            resposta.setMsgResposta("Produto Deletado Com sucesso!");
            return resposta;
        }
        resposta.setMsgResposta("Não foi possivel deletar o produto");
        return resposta;
    }

    public void alterarProduto(ProdutoDto dados, Long id){

        Optional<ProdutoModel> produtoOP = repository.findById(id);
        Optional<CategoriaModel> categoriaOP = repositoryCategoria.findById(dados.getCategoriaId());
        RespostaDto resposta = new RespostaDto();

        if (produtoOP.isPresent() && categoriaOP.isPresent()){

            ProdutoModel model = produtoOP.get();

            model.setPreco(dados.getPreco());
            model.setNome(dados.getNome());
            model.setCategoria(categoriaOP.get());

            repository.save(model);
        }
    }

    public List<ListaProdutoDto> retornarComNomeCategoria(){

        List<ProdutoModel> produto = repository.findAll();
        List<CategoriaModel> categoria = repositoryCategoria.findAll();

        List<ListaProdutoDto> listaDto = new ArrayList<>();

        for (int i = 0; i < produto.size(); i++) {

            ListaProdutoDto lista = new ListaProdutoDto();

            lista.setId(produto.get(i).getId());
            lista.setNome(produto.get(i).getNome());
            lista.setPreco(produto.get(i).getPreco());
            lista.setCategoriaNome(produto.get(i).getNome());

            listaDto.add(lista);
        }

        return listaDto;
    }
}
