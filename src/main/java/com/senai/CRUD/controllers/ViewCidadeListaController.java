package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.RespostaCidadeDto;
import com.senai.CRUD.dtos.RespostaEstadoDto;
import com.senai.CRUD.services.CidadeService;
import com.senai.CRUD.services.EstadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewCidadeListaController {
    private final CidadeService service;

    public ViewCidadeListaController(CidadeService service) {
        this.service = service;
    }
    @GetMapping("/cidadelista")
    public String viewCidadelista(Model model){
        List<RespostaCidadeDto>listaCidade = service.listarCidades();
        model.addAttribute("cidadelista",listaCidade);
        return "cidadelista";
    }
}
