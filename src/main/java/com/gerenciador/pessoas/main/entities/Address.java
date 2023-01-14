package com.gerenciador.pessoas.main.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gerenciador.pessoas.main.entities.enums.TypeAddress;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_ADDRESS")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Campo não informado")
	@Column(nullable = false, length = 100)
	private String logradouro;
	@NotBlank(message = "Campo não informado")
	@Column(nullable = false, length = 20)
	private String cep;
	@NotBlank(message = "Campo não informado")
	@Max(value = 5000, message = "O valor não pode ser maior que 5000")
	@Column(nullable = false)
	private String numero;
	@NotBlank(message = "Campo não informado")
	@Column(nullable = false, length = 40)
	private String cidade;
	private Integer typeAddress;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public Address() {

	}

	public Address(String logradouro, String cep, String numero, String cidade, TypeAddress typeAddress, Person person,
			Integer id) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		setTypeAddress(typeAddress);
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public TypeAddress getTypeAddress() {
		return TypeAddress.valueOf(typeAddress);
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress.getCode();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", cidade="
				+ cidade + ", typeAddress=" + typeAddress + ", person=" + person + "]";
	}

}
