package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaRequestDto;
import com.senai.CRUD.dtos.RequisicaoEstadoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewEstadoCadastrarController {

    @GetMapping("/estado")
    public String viewCategoriaCadastrar(Model model){
        model.addAttribute("estadoDto", new RequisicaoEstadoDto());
        return "estadocadastrar";
    }
}
