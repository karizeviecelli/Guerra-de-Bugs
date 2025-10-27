package com.senai.task_springboot.repositories;

import com.senai.task_springboot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    Optional<UserModel> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    @Query("SELECT COUNT(t) > 0 FROM TaskModel t WHERE t.usuario.email = :email")
    boolean hasTasks(String email);
}