package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.RequisicaoDto;
import com.senai.CRUD.dtos.RespostaDto;
import com.senai.CRUD.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping("/usuario")
    public String cadastrarUsuario(@ModelAttribute("usuarioDto")RequisicaoDto usuarioDto){
         service.adicionarUsuario(usuarioDto);
         return "redirect:/usuariolista";

    }

    @PostMapping("/usuario/{id}")
    public String atualizarUsuario(@ModelAttribute("usuarioDto")RespostaDto usuarioDto, @PathVariable Long id){
        service.atualizarUsuario(usuarioDto,id);
        return "redirect:/usuariolista";
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Message> deletarUsuario(@PathVariable long id){
        service.removerUsuario(id);
        return ResponseEntity.ok().body(new Message("Usuario deletado com sucesso!!"));
    }

}
