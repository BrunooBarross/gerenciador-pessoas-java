package com.gerenciador.pessoas.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.pessoas.main.entities.Address;
import com.gerenciador.pessoas.main.entities.Person;
import com.gerenciador.pessoas.main.entities.enums.TypeAddress;
import com.gerenciador.pessoas.main.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private PersonService personService;

	public Address insert(String personId, Address obj) {
		if (obj.getTypeAddress() == TypeAddress.PRINCIPAL) {
			checkAndUpdateTypeAddress(personId, 0);
		}
		Person person = personService.findById(Integer.parseInt(personId));
		obj.setPerson(person);
		return repository.save(obj);
	}

	private void checkAndUpdateTypeAddress(String personId, Integer typeAdress) {
		Address address = repository.findByIdAndTypeAddress(Integer.parseInt(personId), typeAdress);
		if (address != null) {
			address.setTypeAddress(TypeAddress.SECUNDARIO);
			repository.save(address);
		}
	}
}
