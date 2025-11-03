package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaAtualizarController {

    private final CategoriaService service;

    public CategoriaAtualizarController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categoriaatualizar/{id}")
    public String cadastrarCategoria(@PathVariable Long id, Model model){

        CategoriaDto dto = service.retornarCategoria(id);
        model.addAttribute("categoriaDto", dto);

        return "categoriaatualizar";
    }

    @PostMapping("/categoriaatualizar/{id}")
    public String atualizarCategoria(@PathVariable Long id, @ModelAttribute("usuarioDto") CategoriaDto dto){

        service.alterarCategoria(dto, id);

        return "redirect:/categorialista";
    }
}
