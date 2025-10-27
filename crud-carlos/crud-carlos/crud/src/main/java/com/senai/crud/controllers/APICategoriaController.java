package com.senai.crud.controllers;


import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categoriacadastro")

public class APICategoriaController {


    //--Injeção de dependencia
    private final CategoriaService service;

    //--Construtor


    public APICategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/categoria")
    public String cadastrar(@ModelAttribute("categoriaDto") RequisicaoDto categoriaDto) {

        CategoriaDto CategoriaDto = new CategoriaDto();;
        RespostaDto mensagem = service.cadastrar(CategoriaDto);

        return "redirect:/categorialista";
    }

    @PostMapping
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto, @PathVariable Long id) {

        service.atualizar(id, categoriaDto);

        return "redirect:/categorialista";
    }

    //--Excluir usuário DELETE http://localhost:8080/usuario/1
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id) {

        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("categoria excluido com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }

}







