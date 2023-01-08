package com.gerenciador.pessoas.main.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gerenciador.pessoas.main.entities.Person;
import com.gerenciador.pessoas.main.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Person u1 = new Person(null, "Bruno", sdf.parse("02/09/1992"));
		Person u2 = new Person(null, "João", sdf.parse("08/07/1997"));
		
		personRepository.saveAll(Arrays.asList(u1, u2));
	}

}
