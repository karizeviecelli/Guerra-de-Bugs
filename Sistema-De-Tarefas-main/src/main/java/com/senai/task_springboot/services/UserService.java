package com.senai.task_springboot.services;

import com.senai.task_springboot.dtos.UserDto;
import com.senai.task_springboot.models.UserModel;
import com.senai.task_springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserDto> obterUsuarios() {
        List<UserModel> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean inserirUsuario(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return false; // Usuário já existe
        }
        String hashed = null;
        if (userDto.getPassword() != null) {
            hashed = passwordEncoder.encode(userDto.getPassword());
        }
        UserModel userModel = new UserModel(userDto.getNome(), userDto.getEmail(), hashed);
        userRepository.save(userModel);
        return true;
    }

    public boolean validarLogin(String email, String senha) {
        UserModel usuario = obterUsuario(email);
        if (usuario == null) return false;
        String stored = usuario.getPassword();
        if (stored == null) return false;
        return passwordEncoder.matches(senha, stored);
    }

    @Transactional
    public boolean atualizarUsuario(String email, UserDto userDto) {
        Optional<UserModel> usuarioExistente = userRepository.findByEmail(email);
        if (!usuarioExistente.isPresent()) {
            return false; // Usuário não encontrado
        }
        UserModel userModel = usuarioExistente.get();
        userModel.setNome(userDto.getNome());
        // Não alteramos o email pois é a chave de busca
        userRepository.save(userModel);
        return true;
    }

    public UserModel obterUsuario(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Transactional
    public boolean excluirUsuario(String email) {
        Optional<UserModel> usuarioExistente = userRepository.findByEmail(email);
        if (!usuarioExistente.isPresent()) {
            return false; // Usuário não encontrado
        }
        
        // Verificar se o usuário possui tarefas vinculadas
        if (userRepository.hasTasks(email)) {
            return false; // Usuário vinculado em tarefas
        }
        
        userRepository.delete(usuarioExistente.get());
        return true;
    }

    private UserDto convertToDto(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setNome(userModel.getNome());
        userDto.setEmail(userModel.getEmail());
        return userDto;
    }
}