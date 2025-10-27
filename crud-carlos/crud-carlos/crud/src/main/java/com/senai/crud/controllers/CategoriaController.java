package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping("/categoria")
    public class CategoriaController {

        private final CategoriaService service;

        public CategoriaController(CategoriaService service) {
            this.service = service;
        }

        // Tela de listagem
        @GetMapping("/lista")
        public String listarCategorias(Model model) {
            List<CategoriaDto> listaDto = service.obterCategorias();
            model.addAttribute("listaDto", listaDto);
            return "categorialista";
        }

        // Tela de cadastro (form vazio)
        @GetMapping("/cadastro")
        public String viewCadastro(Model model) {
            model.addAttribute("categoriaDto", new CategoriaDto());
            return "categoriacadastro";
        }

        // Processa cadastro
        @PostMapping("/cadastro")
        public String cadastrar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto) {
            RespostaDto resposta = service.cadastrar(categoriaDto);
            if (resposta.getMensagem().equals("sucesso")) {
                return "redirect:/categoria/lista";
            } else {
                // Pode adicionar tratamento de erro aqui, por simplicidade redireciona
                return "redirect:/categoria/cadastro?erro";
            }
        }

        // Tela para atualizar categoria (carrega dados do banco)
        @GetMapping("/atualizar/{id}")
        public String viewAtualizar(@PathVariable Long id, Model model) {
            CategoriaDto categoriaDto = service.obterCategoria(id);
            model.addAttribute("categoriaDto", categoriaDto);
            return "categoriaatualizar";
        }

        // Processa atualização
        @PostMapping("/atualizar/{id}")
        public String atualizar(@PathVariable Long id, @ModelAttribute("categoriaDto") CategoriaDto categoriaDto) {
            RespostaDto resposta = service.atualizar(id, categoriaDto);
            if (resposta.getMensagem().equals("sucesso")) {
                return "redirect:/categoria/lista";
            } else {
                return "redirect:/categoria/atualizar/" + id + "?erro";
            }
        }

        // Exclusão via GET (para simplificar, você pode usar DELETE via JS)
        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable Long id) {
            service.excluir(id);
            return "redirect:/categoria/lista";
        }
    }




