package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.RequisicaoContatoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.CidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewContatoCadastrarController {
    private final CidadeService service;

    public ViewContatoCadastrarController(CidadeService service) {
        this.service = service;
    }

    @GetMapping("/contatocadastrar")
    public String viewProdutoCadastrar(Model model){
        model.addAttribute("cidadeDto",service.listarCidades() );
        model.addAttribute("contatoDto", new RequisicaoContatoDto());
        return "contatocadastrar";
    }
}
