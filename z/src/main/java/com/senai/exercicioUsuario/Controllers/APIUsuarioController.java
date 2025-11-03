package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.RequisicaoDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Dtos.UsuarioDto;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class APIUsuarioController {

    UsuarioService service;

    public APIUsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping ("/usuario")
    public ResponseEntity <RespostaDto> cadastrar(@RequestBody RequisicaoDto dados){

        RespostaDto resposta = service.adicionarUsuario(dados);

        return ResponseEntity.ok().body(resposta);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> alterar(@RequestBody RequisicaoDto dados, @PathVariable Long id){

        RespostaDto resposta = service.alterarUsuario(dados, id);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> deletarUsuario (@PathVariable Long id){

        RespostaDto resposta = service.deletarUsuario(id);

        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> retornaUsuario (@PathVariable Long id){

        UsuarioDto usuario = service.retornarUsuario(id);

        if(usuario.getId().equals(0L)){
            return ResponseEntity.badRequest().body("Usuario não encontrado");
        }
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/usuario")
    public ResponseEntity<?> retornarListaUsuario(){

        List<UsuarioDto> listaUsuario = service.retornarLista();

        int size = listaUsuario.size();

        if(size == 0){
            return ResponseEntity.badRequest().body("Não possue nenhum usuario cadastrado");
        }

        return ResponseEntity.ok().body(listaUsuario);
    }
}
