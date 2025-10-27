package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.RequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewUsuarioCadastroController {

    @GetMapping("/usuariocadastro")
    public String viewCadastrousuario(Model model){
        model.addAttribute("usuarioDto",new RequisicaoDto());
        return "usuariocadastro";
    }

}
