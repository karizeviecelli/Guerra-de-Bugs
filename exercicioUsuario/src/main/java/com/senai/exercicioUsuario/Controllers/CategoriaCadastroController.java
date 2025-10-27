package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaCadastroController {

    private final CategoriaService service;

    public CategoriaCadastroController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categoriacadastro")
    public String viewCadastrarUsuario(Model model){

        model.addAttribute("categoriaDto", new CategoriaDto());

        return "cadastrocategoria";
    }

    @PostMapping("/categoria")
    public String cadastrarUsuario(@ModelAttribute("categoriaDto")CategoriaDto dto){

        service.cadastrarCategoria(dto);

        return "redirect:/categorialista";
    }
}
