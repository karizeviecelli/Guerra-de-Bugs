package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewCategoriaCadastrarController {

    @GetMapping("/categoriacadastrar")
    public String viewCategoriaCadastrar(Model model){
        model.addAttribute("categoriaDto", new CategoriaRequestDto());
        return "categoriacadastrar";
    }
}
