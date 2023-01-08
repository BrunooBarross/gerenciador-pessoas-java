package com.gerenciador.pessoas.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.pessoas.main.entities.Person;
import com.gerenciador.pessoas.main.repositories.PersonRepository;
import com.gerenciador.pessoas.main.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findById(Integer id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Person not found for id" + id));
	}

	public Person insert(Person obj) {
		return repository.save(obj);
	}

	public Person update(Integer id, Person obj) {
		try {
			Person entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Person not found for id" + id);
		}
	}

	private void updateData(Person entity, Person obj) {
		if (obj.getName() != null && obj.getName().length() > 0) {
			entity.setName(obj.getName());
		}
		if (obj.getBirthDate() != null) {
			entity.setBirthDate(obj.getBirthDate());
		}
	}
}
