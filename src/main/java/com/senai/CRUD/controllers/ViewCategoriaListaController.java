package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewCategoriaListaController {
    private final CategoriaService service;

    public ViewCategoriaListaController(CategoriaService service) {
        this.service = service;
    }
    @GetMapping("/categorialista")
    public String viewListaCategoria(Model model){
        List<CategoriaReponseDto>listacategoria = service.listar();

        model.addAttribute("categorialista",listacategoria);
        return "categorialista";
    }
}
