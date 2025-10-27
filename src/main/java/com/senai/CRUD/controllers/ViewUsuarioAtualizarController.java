package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.RespostaDto;
import com.senai.CRUD.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ViewUsuarioAtualizarController {
    private final UsuarioService service;

    public ViewUsuarioAtualizarController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarioatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){
        Optional<RespostaDto> usuarioDto = service.buscarUsuarioPorId(id);
        model.addAttribute("usuarioDto",usuarioDto.get());
        return "usuarioatualizar";
    }
}
