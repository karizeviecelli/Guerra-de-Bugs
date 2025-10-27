package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewProdutoAtualizarController {
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public ViewProdutoAtualizarController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/produtoatualizar/{id}")
    public String viewProdutoAtualizar(Model model, @PathVariable Long id){
        ProdutoDto produtoDto = produtoService.listarProdutobyId(id);
        List<CategoriaReponseDto> categoriaDto = categoriaService.listar();
        model.addAttribute("categoriasDto", categoriaDto);
        model.addAttribute("produtoDto",produtoDto);
        return "produtoatualizar";
    }
}
