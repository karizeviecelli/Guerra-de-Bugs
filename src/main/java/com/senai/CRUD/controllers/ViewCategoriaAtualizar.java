package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewCategoriaAtualizar {
    private final CategoriaService service;

    public ViewCategoriaAtualizar(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categoriaatualizar/{id}")
    public String viewCategoriaAtualizar(@PathVariable long id, Model model) {
        CategoriaReponseDto categoriaDto = service.buscarCategoria(id);
        model.addAttribute("categoriaDto", categoriaDto);
        return "categoriaatualizar";
    }
}
