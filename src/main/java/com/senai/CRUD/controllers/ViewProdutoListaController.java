package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.ProdutoResponseDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ViewProdutoListaController {
    private final ProdutoService service;
    private final CategoriaService categoriaService;

    public ViewProdutoListaController(ProdutoService service, CategoriaService categoriaService) {
        this.service = service;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/produtolista")
    public String viewListaProduto(Model model){
        List<ProdutoResponseDto>listaProdutoDto = service.listarProdutos();
        List<CategoriaReponseDto>listaCategoriaDto = categoriaService.listar();
        model.addAttribute("produtolista",listaProdutoDto);
        model.addAttribute("categorias",listaCategoriaDto);
        return "produtolista";
    }

    @GetMapping("/produto")
    public String viewListaProdutoFiltro(@RequestParam(required = false,name = "categoria")Optional<Long> id, Model model){
        List<ProdutoResponseDto>listaProdutoDto;
        CategoriaReponseDto categoriaSelecionada = null;

        if(id.isPresent()){
            listaProdutoDto = service.listarProdutosPorCategoria(id.get());
            categoriaSelecionada = categoriaService.buscarCategoria(id.get());
        }else{
            listaProdutoDto = service.listarProdutos();
        }
        List<CategoriaReponseDto>listaCategoriaDto = categoriaService.listar();
        model.addAttribute("categoriaSelecionada",categoriaSelecionada);
        model.addAttribute("produtolista",listaProdutoDto);
        model.addAttribute("categorias",listaCategoriaDto);
        return "produtolista";
    }
}
