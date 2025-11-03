package com.senai.exercicioUsuario.Services;

import com.senai.exercicioUsuario.Dtos.*;
import com.senai.exercicioUsuario.Models.CategoriaModel;
import com.senai.exercicioUsuario.Models.ProdutoModel;
import com.senai.exercicioUsuario.Models.UsuarioModel;
import com.senai.exercicioUsuario.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public RespostaDto adicionarUsuario(RequisicaoDto dados){

        UsuarioModel usuario = new UsuarioModel();

        usuario.setNome(dados.getNome());
        usuario.setNickname(dados.getNickname());
        usuario.setSenha(dados.getSenha());

        repository.save(usuario);

        RespostaDto resposta = new RespostaDto();
        resposta.setMsgResposta("OK");
        return resposta;
    }

    public RespostaDto alterarUsuario(RequisicaoDto dados, Long id) {

        RespostaDto resposta = new RespostaDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){

            UsuarioModel usuario = usuarioOP.get();

            usuario.setNome(dados.getNome());
            usuario.setNickname(dados.getNickname());
            usuario.setSenha(dados.getSenha());
            repository.save(usuario);

            resposta.setMsgResposta("Usuario alterado !");
            return resposta;
        }

        resposta.setMsgResposta("Não foi possivel encontrar o Usuario!");
        return resposta;
    }

    public RespostaDto alterarUsuario(UsuarioDto dados, Long id) {

        RespostaDto resposta = new RespostaDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){

            UsuarioModel usuario = usuarioOP.get();

            usuario.setNome(dados.getNome());
            usuario.setNickname(dados.getNickname());
            usuario.setSenha(dados.getSenha());
            repository.save(usuario);

            resposta.setMsgResposta("Usuario alterado !");
            return resposta;
        }

        resposta.setMsgResposta("Não foi possivel encontrar o Usuario!");
        return resposta;
    }

    public RespostaDto deletarUsuario(Long id){

        RespostaDto resposta = new RespostaDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){

            //encontrou o usuario com tal id
            repository.delete(usuarioOP.get());

            resposta.setMsgResposta("usuario deletado");
            return resposta;
        }

        resposta.setMsgResposta("Não foi possivel encotrar o usuario");
        return resposta;
    }

    public UsuarioDto retornarUsuario(Long id){

        UsuarioDto usuario = new UsuarioDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){

            usuario.setId(usuarioOP.get().getId());
            usuario.setNome(usuarioOP.get().getNome());
            usuario.setNickname(usuarioOP.get().getNickname());
            usuario.setSenha(usuarioOP.get().getSenha());

            return usuario;
        }
        return usuario;
    }

    public List<UsuarioDto> retornarLista(){

        List<UsuarioDto> lista = new ArrayList<>();

        List<UsuarioModel> listaUsuarioModel = repository.findAll();

        for (int i = 0; i < listaUsuarioModel.size(); i++) {

            UsuarioDto usuario = new UsuarioDto();

            usuario.setId(listaUsuarioModel.get(i).getId());
            usuario.setNome(listaUsuarioModel.get(i).getNome());
            usuario.setNickname(listaUsuarioModel.get(i).getNickname());
            usuario.setSenha(listaUsuarioModel.get(i).getSenha());

            lista.add(usuario);
        }
        return lista;
    }

    public RespostaDto verificarLogin(LoginDto login){

        RespostaDto resposta = new RespostaDto();

        List<UsuarioModel> listaUsuario = new ArrayList<>();

        for (int i = 0; i < listaUsuario.size(); i++) {

            if(listaUsuario.get(i).getNickname().equals(login.getLogin())
                    && listaUsuario.get(i).getSenha().equals(login.getSenha())){

                resposta.setMsgResposta("autenticação foi bem sucedida");
                return resposta;
            }
        }
        resposta.setMsgResposta("Login não encontrado");
        return resposta;
    }

    public String validarLogin(LoginDto dto){

        Optional<UsuarioModel> usurioOP = repository.findByNicknameAndSenha(dto.getLogin(), dto.getSenha());

        if (usurioOP.isPresent()){

            return "redirect:/home";
        }else{
            return "redirect:/auth/login?erro";
        }
    }
}
