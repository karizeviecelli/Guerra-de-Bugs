package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.RequisicaoCidadeDto;
import com.senai.CRUD.dtos.RespostaEstadoDto;
import com.senai.CRUD.models.EstadoModel;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.EstadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewCidadeCadastrarController {
    private final EstadoService estadoService;

    public ViewCidadeCadastrarController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/cidadecadastrar")
    public String viewProdutoCadastrar(Model model){
        List<RespostaEstadoDto> estadoDto = estadoService.listarEstados();
        model.addAttribute("estadoDto", estadoDto);
        model.addAttribute("cidadeDto", new RequisicaoCidadeDto());
        return "cidadecadastrar";
    }
}
