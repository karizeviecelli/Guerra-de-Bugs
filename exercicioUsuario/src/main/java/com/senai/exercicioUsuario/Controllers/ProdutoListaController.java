package com.senai.exercicioUsuario.Controllers;

import com.senai.exercicioUsuario.Dtos.ListaProdutoDto;
import com.senai.exercicioUsuario.Dtos.RespostaDto;
import com.senai.exercicioUsuario.Services.CategoriaService;
import com.senai.exercicioUsuario.Services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProdutoListaController {

    private final ProdutoService service;
    private final CategoriaService serviceCategoria;

    public ProdutoListaController(ProdutoService service, CategoriaService serviceCategoria) {
        this.service = service;
        this.serviceCategoria=serviceCategoria;
    }

    @GetMapping("/produtolista")
    public String viewProdutoLista(Model model){

        List<ListaProdutoDto> listaDto = service.retornarComNomeCategoria();

        model.addAttribute("listaDto", listaDto);

        return "produtolista";
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<RespostaDto> excluirProduto(@PathVariable Long id){

        RespostaDto resposta = service.deletarProduto(id);

        if (resposta.getMsgResposta().equals("Não foi possivel deletar o produto")){

            return ResponseEntity.badRequest().body(resposta);
        }else{
            return ResponseEntity.ok().body(resposta);
        }
    }
}
