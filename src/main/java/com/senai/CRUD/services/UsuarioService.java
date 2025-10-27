package com.senai.CRUD.services;

import com.senai.CRUD.dtos.ErrorMessage;
import com.senai.CRUD.dtos.LoginDto;
import com.senai.CRUD.dtos.RequisicaoDto;
import com.senai.CRUD.dtos.RespostaDto;
import com.senai.CRUD.exceptions.EmailExistException;
import com.senai.CRUD.exceptions.LoginInvalidoException;
import com.senai.CRUD.exceptions.UsuarioNotFoundException;
import com.senai.CRUD.models.UsuarioModel;
import com.senai.CRUD.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public boolean adicionarUsuario(RequisicaoDto dados){
        Optional<RespostaDto> existe = listarUsuarios()
                .stream().filter(u -> u.getLogin()
                        .equals(dados.getLogin()))
                .findFirst();

        if (existe.isPresent()){
            throw new EmailExistException();
        }
        UsuarioModel usuario = new UsuarioModel(dados.getSenha(), dados.getLogin(),dados.getNome());

        usuarioRepository.save(usuario);
        return true;
    }

    public List<RespostaDto> listarUsuarios(){
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        List<RespostaDto> respostas = new ArrayList<>();
        for (UsuarioModel usuario : usuarios) {
            respostas.add(new RespostaDto(usuario));
        }
        return respostas;
    }



    public boolean removerUsuario(Long id){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return true;
        }else{
          throw new UsuarioNotFoundException(id);
        }
    }
    @Transactional
    public RespostaDto atualizarUsuario(Long id,RequisicaoDto dados){
    Optional< UsuarioModel> usuarioModel = usuarioRepository.findById(id);
    if (usuarioModel.isPresent()){
        UsuarioModel usuario = usuarioModel.get();
        usuario.setNome(dados.getNome());
        usuario.setLogin(dados.getLogin());
        usuario.setSenha(dados.getSenha());
        usuarioRepository.save(usuario);
        return new RespostaDto(usuario);
    }
        throw new UsuarioNotFoundException(id);

    }
    @Transactional
    public boolean atualizarUsuario(RespostaDto dados,Long id){
        Optional< UsuarioModel> usuarioModel = usuarioRepository.findById(id);
        if (usuarioModel.isPresent()){
            UsuarioModel usuario = usuarioModel.get();
            usuario.setNome(dados.getNome());
            usuario.setLogin(dados.getLogin());
            if(StringUtils.isBlank(dados.getSenha())){
                usuarioRepository.save(usuario);
                return true;
            }else {
                usuario.setSenha(dados.getSenha());
                usuarioRepository.save(usuario);
                return true;
            }
        }
        throw new UsuarioNotFoundException(id);

    }


    public Optional<RespostaDto> buscarUsuarioPorId(Long id) {
        RespostaDto respostaDto = new RespostaDto();
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        return usuario.stream()
                .findFirst()
                .map(RespostaDto::new);
    }
    public boolean validarLogin(LoginDto dto){
       List<UsuarioModel>usuarios = usuarioRepository.findAll();

        for(UsuarioModel u : usuarios){
            if (u.getLogin().equals(dto.getLogin()) && u.getSenha().equals(dto.getSenha())){
                return true;
            }
        }
        throw new LoginInvalidoException();
    }

}
