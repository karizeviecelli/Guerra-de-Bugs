package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.UsuarioDto;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class UsuarioListaController {

    private final UsuarioService service;

    public UsuarioListaController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){

        List<UsuarioDto> listaDto = service.retornarLista();

        model.addAttribute("listaDto", listaDto);

        return "usuariolista";
    }
}
