package com.gerenciador.pessoas.main.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.pessoas.main.entities.Address;
import com.gerenciador.pessoas.main.services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired
	private AddressService service;

	@PostMapping
	public ResponseEntity<Address> insert(@RequestHeader(value = "personId") Integer personId, @RequestBody @Valid Address obj) {
		obj = service.insert(personId, obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).body(obj);
	}
	
	@PutMapping(value = "/main/{id}")
	public ResponseEntity<Address> update(@PathVariable Integer id, @RequestHeader(value = "personId") Integer personId) {
		Address obj = service.updateTypeAddress(id, personId);
		return ResponseEntity.ok().body(obj);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

}
