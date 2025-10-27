package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.CategoriaRequestDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewProdutoCadastrarController {
    private final CategoriaService categoriaService;

    public ViewProdutoCadastrarController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/produtocadastrar")
    public String viewProdutoCadastrar(Model model){
        List<CategoriaReponseDto> categoriaDto = categoriaService.listar();
        model.addAttribute("categoriasDto", categoriaDto);
        model.addAttribute("produtoDto", new ProdutoRequestDto());
        return "produtocadastrar";
    }
}
