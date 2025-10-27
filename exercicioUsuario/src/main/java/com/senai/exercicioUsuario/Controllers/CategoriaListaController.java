package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoriaListaController {

    private final CategoriaService service;

    public CategoriaListaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categorialista")
    public String viewCategoria(Model model){

        List<CategoriaDto> lista = service.listarCategorias();

        model.addAttribute("listaDto", lista);

        return "categorialista";

    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<RespostaDto> deletarCategoria(@PathVariable Long id){

        RespostaDto resposta = service.deletarCategoria(id);

        if (resposta.getMsgResposta().equals("não existe um Categoria com esse id")){
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }
}
