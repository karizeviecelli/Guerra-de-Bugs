package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaReponseDto;
import com.senai.CRUD.dtos.CategoriaRequestDto;
import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.RequisicaoDto;
import com.senai.CRUD.models.CategoriaModel;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/categoria")
    public String cadastrar(@ModelAttribute("categoriaDto") CategoriaRequestDto categoriaDto){
       service.cadastrarCategoria(categoriaDto);
       return "redirect:/categorialista";

    }

    @PostMapping("/categoria/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaRequestDto categoriaDto,@PathVariable Long id){
        service.atualizarCategoria(categoriaDto,id);
            return "redirect:/categorialista";
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Message>deletarCategoria(@PathVariable long id){
        service.deletarCategoria(id);
        return ResponseEntity.ok().body(new Message("Deletado com Sucesso!!"));
    }


}
