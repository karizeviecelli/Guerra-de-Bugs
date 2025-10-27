package com.senai.task_springboot.services;

import com.senai.task_springboot.dtos.TaskDto;
import com.senai.task_springboot.models.TaskModel;
import com.senai.task_springboot.models.UserModel;
import com.senai.task_springboot.repositories.TaskRepository;
import com.senai.task_springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TaskDto> obterTarefas() {
        List<TaskModel> tarefas = taskRepository.findAllWithUsuario();
        return tarefas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public String inserirTarefa(TaskDto taskDto) {
        // Validar se o usuário existe
        Optional<UserModel> userOptional = userRepository.findByEmail(taskDto.getEmailUsuario());
        if (!userOptional.isPresent()) {
            return "USUARIO_NAO_ENCONTRADO";
        }

        UserModel user = userOptional.get();

        // Validar se o usuário já possui tarefa para a data especificada
        if (taskRepository.existsByUsuarioEmailAndDataAgendamento(taskDto.getEmailUsuario(), taskDto.getDataAgendamento())) {
            return "USUARIO_JA_POSSUI_TAREFA_DATA";
        }

        // Validar status
        if (taskDto.getStatus() < 1 || taskDto.getStatus() > 4) {
            return "STATUS_INVALIDO";
        }

        TaskModel task = new TaskModel(
                taskDto.getTitulo(),
                taskDto.getDescricao(),
                taskDto.getDataAgendamento(),
                taskDto.getStatus(),
                user
        );

        taskRepository.save(task);
        return "SUCESSO";
    }

    @Transactional
    public String atualizarTarefa(Long id, TaskDto taskDto) {
        // Validar se a tarefa existe
        Optional<TaskModel> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return "TAREFA_NAO_ENCONTRADA";
        }

        // Validar se o usuário existe
        Optional<UserModel> userOptional = userRepository.findByEmail(taskDto.getEmailUsuario());
        if (!userOptional.isPresent()) {
            return "USUARIO_NAO_ENCONTRADO";
        }

        UserModel user = userOptional.get();

        // Validar status
        if (taskDto.getStatus() < 1 || taskDto.getStatus() > 4) {
            return "STATUS_INVALIDO";
        }

        TaskModel task = taskOptional.get();
        task.setTitulo(taskDto.getTitulo());
        task.setDescricao(taskDto.getDescricao());
        task.setDataAgendamento(taskDto.getDataAgendamento());
        task.setStatus(taskDto.getStatus());
        task.setUsuario(user);

        taskRepository.save(task);
        return "SUCESSO";
    }

    @Transactional
    public boolean excluirTarefa(Long tarefaId) {
        if (taskRepository.existsById(tarefaId)) {
            taskRepository.deleteById(tarefaId);
            return true;
        }
        return false;
    }

    private TaskDto convertToDto(TaskModel task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitulo(task.getTitulo());
        dto.setDescricao(task.getDescricao());
        dto.setDataAgendamento(task.getDataAgendamento());
        dto.setStatus(task.getStatus());
        dto.setEmailUsuario(task.getUsuario().getEmail());
        return dto;
    }
}