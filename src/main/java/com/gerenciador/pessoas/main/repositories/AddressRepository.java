package com.gerenciador.pessoas.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciador.pessoas.main.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_ADDRESS WHERE PERSON_ID = (:id) AND TYPE_ADDRESS = (:type)")
	Address findByIdAndTypeAddress(Integer id, Integer type);

}
