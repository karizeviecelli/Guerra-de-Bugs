package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.*;
import com.senai.exercicioUsuario.Services.ProdutoService;
import com.senai.exercicioUsuario.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class ProdutoController {

    ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    /*
    @PostMapping("/produto")
    public ResponseEntity<RespostaDto> cadastrarProduto(@RequestBody ProdutoDto produto){

        RespostaDto resposta = service.cadastrarProduto(produto);

        if (resposta.getMsgResposta().equals("Erro")){
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

     */
    @GetMapping("/produto")
    public ResponseEntity<?> retornarListaProdutos(){

        List<ProdutoDto> listaProduto = service.listarTodosProdutos();

        if (listaProduto.isEmpty()){
            return ResponseEntity.badRequest().body("Nenhum Produto Cadastrado!");
        }

        return ResponseEntity.ok().body(listaProduto);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<?> listarProduto(@PathVariable Long id){

        ProdutoDto produto = service.retornaProduto(id);

        if (produto.getId() == null){
            return ResponseEntity.badRequest().body("Produto não existe!");
        }

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<RespostaDto> excluirProduto(@PathVariable Long id){

        RespostaDto resposta = service.deletarProduto(id);

        if (resposta.getMsgResposta().equals("Não foi possivel deletar o produto")){

            return ResponseEntity.badRequest().body(resposta);
        }
        return ResponseEntity.ok().body(resposta);
    }
/*
    @PutMapping("/produto/{id}")
    public ResponseEntity<RespostaDto> alterarProduto(@RequestBody ProdutoDto dados, @PathVariable Long id){

        RespostaDto resposta = service.alterarProduto(dados,id);

        if (resposta.getMsgResposta().equals("Não foi possivel alterar o Produto!")){

            return ResponseEntity.badRequest().body(resposta);
        }
        return ResponseEntity.ok().body(resposta);
    }

 */
}
