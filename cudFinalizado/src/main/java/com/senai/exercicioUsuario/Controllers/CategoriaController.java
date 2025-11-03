package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.CategoriaDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CategoriaController {

    CategoriaService service;

    public CategoriaController(CategoriaService service){
        this.service = service;
    }

    /*
    @PostMapping("/categoria")
    public ResponseEntity<RespostaDto> cadastrarCategoria(@RequestBody CategoriaDto categoria){

        RespostaDto resposta = service.cadastrarCategoria(categoria);

        return ResponseEntity.ok().body(resposta);
    }
     */

    @GetMapping("/categoria")
    public ResponseEntity<?> listarCategoria(){

        List<CategoriaDto> lista = service.listarCategorias();

        if (lista.isEmpty()){
            return ResponseEntity.badRequest().body("Não possue nenhuma categoria cadastrada!");
        }
        return ResponseEntity.ok().body(lista);
    }
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<RespostaDto> deletarCategoria(@PathVariable Long id){

        RespostaDto resposta = service.deletarCategoria(id);

        if (resposta.getMsgResposta().equals("não existe um Categoria com esse id")){
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }
/*
    @PutMapping("/categoria/{id}")
    public ResponseEntity<RespostaDto> AlterarCategoria(@PathVariable Long id, @RequestBody CategoriaDto dados){

        RespostaDto resposta = service.alterarCategoria(dados, id);

        if (resposta.getMsgResposta().equals("Não foi possivel alterar!")){

            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

 */

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaDto> retornarCategoria(@PathVariable Long id){

        CategoriaDto categoria = service.retornarCategoria(id);

        if (categoria.getNome() == null){

            return ResponseEntity.badRequest().body(categoria);
        }
        return ResponseEntity.ok().body(categoria);
    }
}
