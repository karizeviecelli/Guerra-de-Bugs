package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.ProdutoDto;
import com.senai.CRUD.dtos.ProdutoRequestDto;
import com.senai.CRUD.dtos.RequisicaoCidadeDto;
import com.senai.CRUD.services.CidadeService;
import com.senai.CRUD.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CidadeController {

    private CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @PostMapping("/cidade")
    public String cidadeCadastrar(@ModelAttribute("cidadeDto") RequisicaoCidadeDto cidadeDto){
     service.cadastrarCidade(cidadeDto);
     return "redirect:/cidadelista";

    }

    @PostMapping("/cidade/{id}")
    public String cidadeAtualizar(@ModelAttribute("cidadeDto") RequisicaoCidadeDto cidadeDto, @PathVariable Long id){
         service.atualizarCidade(cidadeDto, id);
         return "redirect:/cidadelista";

    }
    @DeleteMapping("/cidade/{id}")
    public ResponseEntity<Message>deletarCidade(@PathVariable long id){
         service.deletarCidade(id);
         return ResponseEntity.ok().body(new Message("Cidade excluida com sucesso!!"));

    }



}
