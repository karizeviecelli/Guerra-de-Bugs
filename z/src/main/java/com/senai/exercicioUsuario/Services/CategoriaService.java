package com.senai.exercicioUsuario.Services;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Dtos.MensagemDeErroDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Models.CategoriaModel;
import com.senai.exercicioUsuario.Models.UsuarioModel;
import com.senai.exercicioUsuario.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public MensagemDeErroDto cadastrarCategoria(CategoriaDto categoria){

        Optional<CategoriaModel> categoriaOP = repository.findByNome(categoria.getNome());
        MensagemDeErroDto dto = new MensagemDeErroDto();

        if (categoriaOP.isEmpty()) {

            CategoriaModel model = new CategoriaModel();
            model.setNome(categoria.getNome());
            model.setDescricao(categoria.getDescricao());
            repository.save(model);

            dto.setMensagem("Categoria Cadastrada com sucesso!");
            return dto;
        }
        dto.setMensagem("Erro: Categoria já cadastrada");
        return dto;
    }

    public List<CategoriaDto> listarCategorias(){

        List<CategoriaDto> lista = new ArrayList<>();

        List<CategoriaModel> listaCategoriaModel = repository.findAll();

        for (int i = 0; i < listaCategoriaModel.size(); i++) {

            CategoriaDto categoria = new CategoriaDto();

            categoria.setId(listaCategoriaModel.get(i).getId());
            categoria.setNome(listaCategoriaModel.get(i).getNome());
            categoria.setDescricao((listaCategoriaModel.get(i).getDescricao()));

            lista.add(categoria);
        }
        return lista;
    }

    public RespostaDto deletarCategoria(Long id){

        RespostaDto resposta = new RespostaDto();

        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        if (categoriaOP.isPresent()){

            repository.deleteById(id);
            resposta.setMsgResposta("categoria deletada!");
            return resposta;
        }

        resposta.setMsgResposta("não existe um Categoria com esse id");
        return resposta;
    }

    public void alterarCategoria(CategoriaDto dados, Long id){


        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        if (categoriaOP.isPresent()){

            CategoriaModel model = categoriaOP.get();
            model.setNome(dados.getNome());
            model.setDescricao(dados.getDescricao());
            repository.save(model);
        }

    }

    public CategoriaDto retornarCategoria(Long id){

        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        CategoriaDto categoria = new CategoriaDto();

        if (categoriaOP.isPresent()){

            categoria.setId(categoriaOP.get().getId());
            categoria.setNome(categoriaOP.get().getNome());
            categoria.setDescricao(categoriaOP.get().getDescricao());

            return categoria;
        }
        return categoria;
    }
}
