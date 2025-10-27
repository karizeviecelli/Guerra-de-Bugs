package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.dtos.RespostaCidadeDto;
import com.senai.CRUD.dtos.RespostaContatoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.CidadeService;
import com.senai.CRUD.services.ContatoService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewContatoAtualizarController {
    private final ContatoService service;
    private final CidadeService cidadeService;

    public ViewContatoAtualizarController(ContatoService service, CidadeService cidadeService) {
        this.service = service;
        this.cidadeService = cidadeService;
    }


    @GetMapping("/contatoatualizar/{id}")
    public String viewContatoAtualizar(Model model, @PathVariable Long id){
        RespostaContatoDto contatoDto = service.listarContatoById(id);
        List<RespostaCidadeDto> cidadeDto = cidadeService.listarCidades();
        model.addAttribute("cidadeDto", cidadeDto);
        model.addAttribute("contatoDto",contatoDto);
        return "contatoatualizar";
    }
}
