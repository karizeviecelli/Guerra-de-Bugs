package com.senai.task_springboot.repositories;

import com.senai.task_springboot.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    
    @Query("SELECT COUNT(t) > 0 FROM TaskModel t WHERE t.usuario.email = :email AND t.dataAgendamento = :data")
    boolean existsByUsuarioEmailAndDataAgendamento(@Param("email") String email, @Param("data") LocalDate data);
    
    @Query("SELECT t FROM TaskModel t WHERE t.usuario.email = :email AND t.dataAgendamento = :data")
    List<TaskModel> findByUsuarioEmailAndDataAgendamento(@Param("email") String email, @Param("data") LocalDate data);
    
    @Query("SELECT t FROM TaskModel t JOIN FETCH t.usuario")
    List<TaskModel> findAllWithUsuario();
}