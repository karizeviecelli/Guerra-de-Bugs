package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.RespostaDto;
import com.senai.CRUD.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewUsuarioListaController {
    private final UsuarioService service;

    public ViewUsuarioListaController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){

        List<RespostaDto>listaDto = service.listarUsuarios();
        model.addAttribute("listaDto",listaDto);

        return "usuariolista";
    }
}
