package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.ProdutoResponseDto;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    @PostMapping("/produto")
    public String produtoCadastrar(@ModelAttribute("produtoDto")ProdutoRequestDto produtoDto){
     service.cadastroProduto(produtoDto);
     return "redirect:/produtolista";

    }

    @PostMapping("/produto/{id}")
    public String produtoAtualizar(@ModelAttribute("produtoDto") ProdutoDto produtoDto, @PathVariable Long id){
         service.atualizarProduto(produtoDto,id);
         return "redirect:/produtolista";

    }
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Message>deletarProduto(@PathVariable long id){
         service.deletarProduto(id);
         return ResponseEntity.ok().body(new Message("Produto excluido com sucesso!!"));

    }



}
