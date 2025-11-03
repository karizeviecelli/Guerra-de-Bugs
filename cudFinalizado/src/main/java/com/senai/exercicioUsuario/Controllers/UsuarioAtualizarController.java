package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.UsuarioDto;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioAtualizarController {

    private final UsuarioService service;

    public UsuarioAtualizarController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarioatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        UsuarioDto usuarioDto = service.retornarUsuario(id);
        model.addAttribute("usuarioDto", usuarioDto);

        return "usuarioatualizar";
    }


}
