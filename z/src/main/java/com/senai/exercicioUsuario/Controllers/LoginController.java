package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.LoginDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {

    UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String viewLogin(Model model){

        LoginDto dto = new LoginDto();
        model.addAttribute("loginDto", dto);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto") LoginDto dto){

        String resposta = service.validarLogin(dto);
        return resposta;
    }

}
