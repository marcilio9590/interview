package com.spring.boot.interview.enums;

public enum SexoEnum {

	MASCULINO("Masculino", 1), FEMININO("Feminino", 2);

	private String descricao;
	private long cod;

	SexoEnum(String descricaoParam, long codParam) {
		descricao = descricaoParam;
		cod = codParam;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricaoParam) {
		this.descricao = descricaoParam;
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long codParam) {
		this.cod = codParam;
	}

}
