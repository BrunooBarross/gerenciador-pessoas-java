package com.gerenciador.pessoas.main;

import java.text.SimpleDateFormat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciador.pessoas.main.entities.Person;
import com.gerenciador.pessoas.main.resources.PersonResource;

public class PersonResourceTest extends MainApplicationTests{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private MockMvc mocMvc;  
	
	@Autowired
	private PersonResource personResource;
	
	@Before
	public void setUp() {
		this.mocMvc = MockMvcBuilders.standaloneSetup(personResource).build();
	}
	
	@Test
	public void criarPessoaComDadosCorretos_RetornarStatusCode201() throws Exception {
		Person person = new Person(null, "Ana", sdf.parse("01/01/2000"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(person);
		
		System.out.println(json + "aquiiiiiiiiiiiiiiii");
		
		this.mocMvc.perform(MockMvcRequestBuilders.post("/persons")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json)
						)
					.andExpect(MockMvcResultMatchers.status().isCreated())
					.andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/persons")));
	}
	
	@Test
	public void criarPessoaComDadosIncorretos_RetornarStatusCode400() throws Exception {
		this.mocMvc.perform(MockMvcRequestBuilders.post("/persons")
							.contentType(MediaType.APPLICATION_JSON)
							.content("")
						)
					.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
