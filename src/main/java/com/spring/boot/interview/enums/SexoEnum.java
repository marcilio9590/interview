package com.spring.boot.interview.enums;

import java.util.HashMap;
import java.util.Map;

public enum SexoEnum {

	MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

	private String descricao;
	private String cod;

	SexoEnum(String descricaoParam, String codParam) {
		descricao = descricaoParam;
		cod = codParam;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricaoParam) {
		this.descricao = descricaoParam;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String codParam) {
		this.cod = codParam;
	}

	private static Map<String, SexoEnum> map;

	static {
		map = new HashMap<>();
		for (SexoEnum v : SexoEnum.values())
			map.put(v.getCod(), v);
	}

	public static SexoEnum get(String sigla) {
		if (sigla == null)
			return null;

		return map.get(sigla.toUpperCase());
	}

}
