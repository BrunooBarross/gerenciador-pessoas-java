package com.gerenciador.pessoas.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.pessoas.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
