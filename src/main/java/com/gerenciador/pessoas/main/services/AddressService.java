package com.gerenciador.pessoas.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.pessoas.main.entities.Address;
import com.gerenciador.pessoas.main.entities.Person;
import com.gerenciador.pessoas.main.entities.enums.TypeAddress;
import com.gerenciador.pessoas.main.repositories.AddressRepository;
import com.gerenciador.pessoas.main.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private PersonService personService;

	public Address insert(Integer personId, Address obj) {
		if (obj.getTypeAddress() == TypeAddress.PRINCIPAL) {
			checkAndUpdateTypeAddress(personId, 0);
		}
		Person person = personService.findById(personId);
		obj.setPerson(person);
		return repository.save(obj);
	}

	public Address updateTypeAddress(Integer id, Integer personId) {
		try {
			Address entity = repository.getByIdAndUserId(id, personId);
			Address mainAddress = repository.getByIdAndTypeAddress(personId, 0);
			if (mainAddress != null) {
				if (entity.getId() != mainAddress.getId()) {
					checkAndUpdateTypeAddress(personId, 0);
					entity.setTypeAddress(TypeAddress.PRINCIPAL);
				}
			}
			return repository.save(entity);
		} catch (NullPointerException e) {
			throw new ResourceNotFoundException(
					"Person or Address not found " + "addressId " + id + " personId " + personId);
		}
	}

	private void checkAndUpdateTypeAddress(Integer personId, Integer typeAdress) {
		Address address = repository.getByIdAndTypeAddress(personId, typeAdress);
		if (address != null) {
			address.setTypeAddress(TypeAddress.SECUNDARIO);
			repository.save(address);
		}
	}
}
