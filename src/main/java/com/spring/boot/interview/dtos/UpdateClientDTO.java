package com.spring.boot.interview.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateClientDTO {

	@NotNull
	private Long id;
	@NotEmpty
	private String name = "";

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

}
