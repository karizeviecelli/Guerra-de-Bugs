package com.senai.task_springboot.controllers;

import com.senai.task_springboot.dtos.UserDto;
import com.senai.task_springboot.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> obterUsuarios() {
        List<UserDto> usuarios = userService.obterUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).body("Lista vazia de usuários.");
        }
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid UserDto user) {
        if (!userService.inserirUsuario(user)) {
            return ResponseEntity.status(409).body("Já existe usuário.");
        }
        return ResponseEntity.ok("Usuário inserido com sucesso.");
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable String email, @RequestBody @Valid UserDto user) {
        if (!userService.atualizarUsuario(email, user)) {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
        return ResponseEntity.ok("Usuário atualizado com sucesso.");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> excluirUsuario(@PathVariable String email) {
        boolean sucesso = userService.excluirUsuario(email);
        if (!sucesso) {
            // Verificar se é por não existir ou por estar vinculado
            if (userService.obterUsuario(email) == null) {
                return ResponseEntity.status(404).body("Usuário não encontrado.");
            } else {
                return ResponseEntity.status(409).body("Usuário vinculado em tarefas.");
            }
        }
        return ResponseEntity.ok("Usuário excluído com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest login) {
        boolean ok = userService.validarLogin(login.getEmail(), login.getPassword());
        if (!ok) return ResponseEntity.status(401).body("Credenciais inválidas.");
        return ResponseEntity.ok("Login efetuado com sucesso.");
    }

    // Classe interna simples para receber JSON de login
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
