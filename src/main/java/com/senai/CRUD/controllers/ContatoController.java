package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.RequisicaoContatoDto;
import com.senai.CRUD.services.ContatoService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController {

    private ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping("/contato")
    public String contatoCadastrar(@ModelAttribute("contatoDto")RequisicaoContatoDto contatoDto){
     service.CadastrarContato(contatoDto);
     return "redirect:/contatolista";

    }

    @PostMapping("/contato/{id}")
    public String contatoAtualizar(@ModelAttribute("contatoDto") RequisicaoContatoDto contatoDto, @PathVariable Long id){
         service.atualizarContato(contatoDto,id);
         return "redirect:/contatolista";

    }
    @DeleteMapping("/contato/{id}")
    public ResponseEntity<Message>deletarProduto(@PathVariable long id){
         service.deletarContato(id);
         return ResponseEntity.ok().body(new Message("Contato excluido com sucesso!!"));

    }



}
