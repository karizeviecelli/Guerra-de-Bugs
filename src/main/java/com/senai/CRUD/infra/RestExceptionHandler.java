package com.senai.CRUD.infra;

import com.senai.CRUD.dtos.RestMessageErrorDto;
import com.senai.CRUD.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoriaEmUsoException.class)
    private String categoriaEmUso(CategoriaEmUsoException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");
        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.CONFLICT );

        redirectAttributes.addFlashAttribute("erroDto",err);
        return "redirect:"+redirectURL;
    }

    @ExceptionHandler(CategoriaExistenteException.class)
    private String categoriaExistente(CategoriaExistenteException ex,RedirectAttributes redirectAttributes,HttpServletRequest request) {

        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.CONFLICT);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    private String categoriaNaoExistente(CategoriaNotFoundException ex,RedirectAttributes redirectAttributes,HttpServletRequest request) {

        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }

    @ExceptionHandler(ProdutoNotFound.class)
    private String produtoNotFound(ProdutoNotFound ex,RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }

    @ExceptionHandler(EmailExistException.class)
    private String loginExistente(EmailExistException ex,RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.CONFLICT);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(UsuarioNotFoundException.class)
    private String usuarioNotFound(UsuarioNotFoundException ex,RedirectAttributes redirectAttributes,HttpServletRequest request) {

        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(LoginInvalidoException.class)
    private String loginInvalido(LoginInvalidoException ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }

    @ExceptionHandler(EstadoExistException.class)
    private String estadoExiste(EstadoExistException ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.CONFLICT);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(EstadoNotFoundException.class)
    private String estadoNotFound(EstadoNotFoundException ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(CidadeExistenteException.class)
    private String cidadeExiste(CidadeExistenteException ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.CONFLICT);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(CidadenotFound.class)
    private String cidadeNotFound(CidadenotFound ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }
    @ExceptionHandler(ContatoNotFound.class)
    private String contatoNotFound(ContatoNotFound ex,RedirectAttributes redirectAttributes,HttpServletRequest request ) {
        //Ira pegar a url que ele estava antes EX: /cadastro
        String referer = request.getHeader("Referer");

        // Adiciona o parâmetro ?erro ou &erro dependendo da URL
        String redirectURL = referer.contains("?") ? referer + "&erro" : referer + "?erro";

        RestMessageErrorDto err = new RestMessageErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);

        redirectAttributes.addFlashAttribute("erroDto",err);

        return "redirect:"+redirectURL;
    }

}
