package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.RespostaEstadoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.EstadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewEstadoAtualizar {
    private final EstadoService service;

    public ViewEstadoAtualizar(EstadoService service) {
        this.service = service;
    }

    @GetMapping("/estadoatualizar/{id}")
    public String viewEstadoAtualizar(@PathVariable long id, Model model) {
        RespostaEstadoDto estadoDto = service.estadoById(id);
        model.addAttribute("estadoDto", estadoDto);
        return "estadoatualizar";
    }
}
