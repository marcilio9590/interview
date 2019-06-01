package com.spring.boot.interview.dtos;

import javax.validation.constraints.NotEmpty;

public class ClientDTO {

	private Long id;
	@NotEmpty(message = "Nome Inválido")
	private String name = "";
	@NotEmpty(message = "Sexo Inválido")
	private String gender;
	@NotEmpty(message = "Data de Nascimento Inválida")
	private String dtBirth;
	private int age;
	@NotEmpty(message = "Cidade Inválida")
	private String city = "";

	public Long getId() {
		return id;
	}

	public void setId(Long idParam) {
		this.id = idParam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(String dtBirth) {
		this.dtBirth = dtBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
