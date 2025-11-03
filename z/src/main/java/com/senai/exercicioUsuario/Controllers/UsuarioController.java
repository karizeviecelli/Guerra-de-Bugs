package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.RequisicaoDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Dtos.UsuarioDto;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuario")
    public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto usuarioDto){

        RespostaDto resposta = service.adicionarUsuario(usuarioDto);


        return "redirect:/usuariolista";
    }

    @PostMapping("/usuario/{id}")
    public String atualizar(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto, @PathVariable Long id){

        RespostaDto resposta = service.alterarUsuario(usuarioDto, id);

        return "redirect:/usuariolista";
    }
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> deletarUsuario (@PathVariable Long id){

        RespostaDto resposta = service.deletarUsuario(id);

        if(resposta.equals("usuario deletado")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
        return ResponseEntity.ok().body(resposta);

    }
}
