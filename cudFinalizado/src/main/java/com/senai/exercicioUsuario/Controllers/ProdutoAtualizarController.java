package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Dtos.ProdutoDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import com.senai.exercicioUsuario.Services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdutoAtualizarController {

    private final ProdutoService service;
    private final CategoriaService serviceCategoria;

    public ProdutoAtualizarController(ProdutoService service, CategoriaService serviceCategoria) {
        this.service = service;
        this.serviceCategoria=serviceCategoria;
    }

    @GetMapping("/produtoatualizar/{id}")
    public String viewProdutoAtualizar(@PathVariable Long id, Model model){

        List<CategoriaDto> lista = serviceCategoria.listarCategorias();
        ProdutoDto dto = service.retornaProduto(id);

        model.addAttribute("produtoDto", dto);
        model.addAttribute("categoriasDto", lista);

        return "produtoatualizar";
    }

    @PostMapping("/produtoatualizar/{id}")
    public String atualizarProduto(@ModelAttribute("produtoDto") ProdutoDto dto, @PathVariable Long id){

        service.alterarProduto(dto, id);

        return "redirect:/produtolista";
    }
}
