package com.gerenciador.pessoas.main;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class) 
@TestPropertySource(locations = "classpath:application.properties")
class MainApplicationTests {

	@Test
	void contextLoads() {
	}

}
