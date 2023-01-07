package com.gerenciador.pessoas.main.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gerenciador.pessoas.main.entities.User;
import com.gerenciador.pessoas.main.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Bruno", sdf.parse("02/09/1992"));
		User u2 = new User(null, "João", sdf.parse("08/07/1997"));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
