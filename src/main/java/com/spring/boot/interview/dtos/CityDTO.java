package com.spring.boot.interview.dtos;

import javax.validation.constraints.NotEmpty;

public class CityDTO {

	private Long id;
	@NotEmpty(message = "Nome Inválido")
	private String name;
	@NotEmpty(message = "Estado Inválido")
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long idParam) {
		this.id = idParam;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameParam) {
		this.name = nameParam;
	}

	public String getState() {
		return state;
	}

	public void setState(String stateParam) {
		this.state = stateParam;
	}

}
