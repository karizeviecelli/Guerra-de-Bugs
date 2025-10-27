package com.senai.exercicioUsuario.repositories;

import com.senai.exercicioUsuario.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.security.auth.spi.LoginModule;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNicknameAndSenha(String login, String senha);
}
