package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.LoginDto;
import com.senai.CRUD.dtos.UsuarioSessaoDto;
import com.senai.CRUD.services.UsuarioService;
import com.senai.CRUD.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    private UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

   @GetMapping("/login")
    public String viewLogin(Model model){

        LoginDto loginDto = new LoginDto();

        model.addAttribute("loginDto",loginDto);

       return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto")LoginDto loginDto, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessaoDto = service.validarLogin(loginDto);

        ControleSessao.registrar(request,usuarioSessaoDto);


            return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        ControleSessao.encerrar(request);
        return "redirect:/login";
    }

}
