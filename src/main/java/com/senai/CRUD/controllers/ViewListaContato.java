package com.senai.CRUD.controllers;

import com.senai.CRUD.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewListaContato {

    private final ContatoService service;

    public ViewListaContato(ContatoService service) {
        this.service = service;
    }

    @GetMapping("/contatolista")
    public String listarContatos(Model model){
        model.addAttribute("contatolista",service.listaContatos());
        return "contatolista";
    }
}
