package com.senai.task_springboot.controllers;

import com.senai.task_springboot.dtos.TaskDto;
import com.senai.task_springboot.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Object> obterTarefas() {
        List<TaskDto> tarefas = taskService.obterTarefas();
        if (tarefas.isEmpty()) {
            return ResponseEntity.status(404).body("Lista vazia de tarefas.");
        }
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping
    public ResponseEntity<Object> criarTask(@RequestBody @Valid TaskDto task) {
        String resultado = taskService.inserirTarefa(task);
        
        switch (resultado) {
            case "SUCESSO":
                return ResponseEntity.ok("Tarefa inserida com sucesso.");
            case "USUARIO_NAO_ENCONTRADO":
                return ResponseEntity.status(404).body("Usuário da tarefa não encontrado.");
            case "USUARIO_JA_POSSUI_TAREFA_DATA":
                return ResponseEntity.status(409).body("Usuário já possui agenda para a data informada.");
            case "STATUS_INVALIDO":
                return ResponseEntity.status(400).body("Status inválido. Use: 1-Em aberto, 2-Em andamento, 3-Concluído, 4-Cancelado.");
            default:
                return ResponseEntity.status(400).body("Erro na inserção da tarefa.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTask(@PathVariable Long id, @RequestBody @Valid TaskDto task) {
        String resultado = taskService.atualizarTarefa(id, task);
        
        switch (resultado) {
            case "SUCESSO":
                return ResponseEntity.ok("Tarefa atualizada com sucesso.");
            case "TAREFA_NAO_ENCONTRADA":
                return ResponseEntity.status(404).body("Tarefa não encontrada.");
            case "USUARIO_NAO_ENCONTRADO":
                return ResponseEntity.status(404).body("Usuário da tarefa não encontrado.");
            case "STATUS_INVALIDO":
                return ResponseEntity.status(400).body("Status inválido. Use: 1-Em aberto, 2-Em andamento, 3-Concluído, 4-Cancelado.");
            default:
                return ResponseEntity.status(400).body("Erro na atualização da tarefa.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirTask(@PathVariable Long id) {
        if (!taskService.excluirTarefa(id)) {
            return ResponseEntity.status(404).body("Tarefa não encontrada.");
        }
        return ResponseEntity.ok("Tarefa excluída com sucesso.");
    }
}