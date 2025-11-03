package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Dtos.ProdutoDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import com.senai.exercicioUsuario.Services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdutoCadastroController {

    private final ProdutoService service;
    private final CategoriaService serviceCategoria;

    public ProdutoCadastroController(ProdutoService service, CategoriaService serviceCategoria) {
        this.service = service;
        this.serviceCategoria=serviceCategoria;
    }

    @GetMapping("/produtocadastro")
    public String viewCadastroProduto(Model model){

        model.addAttribute("produtoDto", new ProdutoDto());
        List<CategoriaDto> lista = serviceCategoria.listarCategorias();

        model.addAttribute("categoriasDto", lista);

        return "produtocadastro";
    }

    @PostMapping("/produtocadastro")
    public String cadastrarProduto(@ModelAttribute("produtoDto") ProdutoDto dto){

        service.cadastrarProduto(dto);

        return "redirect:/produtolista";
    }
}
