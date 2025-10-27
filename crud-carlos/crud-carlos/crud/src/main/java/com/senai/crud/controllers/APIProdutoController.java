package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API/produto")

public class APIProdutoController {
    

        //--Injeção de dependencia
        private final ProdutoService service;

        //--Construtor
        public APIProdutoController(ProdutoService service) {
            
            this.service = service;
        }

        @PostMapping("/produto")
        public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto usuarioDto){

            CategoriaDto ProdutoDto = null;
            CategoriaDto CategoriaDto;
            RespostaDto mensagem = service.cadastrar(ProdutoDto);

            return "redirect:/usuariolista";
        }

        @PostMapping
        public String atualizar(@ModelAttribute("usuarioDto") ProdutoDto produtoDto, @PathVariable Long id){

            service.atualizar(id, produtoDto);

            return "redirect:/usuariolista";
        }
        //--Excluir usuário DELETE http://localhost:8080/usuario/1
        @DeleteMapping("/{id}")
        public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){

            RespostaDto resposta = service.excluir(id);

            if (resposta.getMensagem().equals("sucesso")) {
                resposta.setMensagem("produto excluido com sucesso");
                return ResponseEntity.ok().body(resposta);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
            }

        }

    }







