package com.senai.CRUD.controllers;

import com.senai.CRUD.dtos.CategoriaRequestDto;
import com.senai.CRUD.dtos.Message;
import com.senai.CRUD.dtos.RequisicaoEstadoDto;
import com.senai.CRUD.services.CategoriaService;
import com.senai.CRUD.services.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class estadoController {

    private EstadoService service;

    public estadoController(EstadoService service) {
        this.service = service;
    }

    @PostMapping("/estado")
    public String cadastrar(@ModelAttribute("estadoDto") RequisicaoEstadoDto estadoDto){
       service.cadastrarEstado(estadoDto);
       return "redirect:/estadolista";

    }

    @PostMapping("/estado/{id}")
    public String atualizar(@ModelAttribute("estadoDto") RequisicaoEstadoDto estadoDto,@PathVariable Long id){
        service.atualizarEstado(estadoDto,id);
            return "redirect:/estadolista";
    }

    @DeleteMapping("/estado/{id}")
    public ResponseEntity<Message>deletarEstado(@PathVariable long id){
        service.deletarEstado(id);
        return ResponseEntity.ok().body(new Message("Deletado com Sucesso!!"));
    }


}
