package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.RequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioCadastroController {

    @GetMapping("/usuariocadastro")
    public String viewCadastro(Model model){

        model.addAttribute("usuarioDto", new RequisicaoDto());
        return "usuariocadastro";
    }
}
