package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.RespostaEstadoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.EstadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewEstadoListaController {
    private final EstadoService service;

    public ViewEstadoListaController(EstadoService service) {
        this.service = service;
    }
    @GetMapping("/estadolista")
    public String viewListaEstado(Model model){
        List<RespostaEstadoDto>listaestado = service.listarEstados();
        model.addAttribute("estadolista",listaestado);
        return "estadolista";
    }
}
