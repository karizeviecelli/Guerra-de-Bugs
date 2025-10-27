package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RespostaDto> cadastrar(@RequestBody ProdutoDto produtoDto){

        CategoriaDto categoriaDto = new CategoriaDto();
        RespostaDto resposta = service.cadastrar(categoriaDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Produto cadastrado com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaDto> atualizar(@PathVariable Long id, @RequestBody ProdutoDto produtoDto){

        RespostaDto resposta = service.atualizar(id,produtoDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Produto atualizado com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<RespostaDto> excluir(@PathVariable Long id){
        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("produto excluido com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obter(@PathVariable Long id){
        return ResponseEntity.ok().body(service.obterProduto(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> lista(){
        return ResponseEntity.ok().body(service.obterProdutos());
    }
}

