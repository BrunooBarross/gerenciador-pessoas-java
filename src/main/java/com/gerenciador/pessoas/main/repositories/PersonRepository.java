package com.gerenciador.pessoas.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.pessoas.main.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
