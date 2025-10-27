package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.*;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.CidadeService;
import com.senai.CRUD.services.EstadoService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewCidadeAtualizarController {
    private final EstadoService estadoService;
    private final CidadeService cidadeService;

    public ViewCidadeAtualizarController(CidadeService cidadeService, EstadoService estadoService) {
        this.cidadeService = cidadeService;
        this.estadoService = estadoService;
    }

    @GetMapping("/cidadeatualizar/{id}")
    public String viewProdutoAtualizar(Model model, @PathVariable Long id){
        RespostaCidadeDto cidadeDto = cidadeService.cidadebyId(id);
        List<RespostaEstadoDto> estadoDto = estadoService.listarEstados();
        model.addAttribute("estadoDto", estadoDto);
        model.addAttribute("cidadeDto",cidadeDto);
        return "cidadeatualizar";
    }
}
