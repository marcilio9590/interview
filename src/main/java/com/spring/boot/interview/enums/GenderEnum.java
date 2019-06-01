package com.spring.boot.interview.enums;

import java.util.HashMap;
import java.util.Map;

public enum GenderEnum {

	MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

	private String descricao;
	private String cod;

	GenderEnum(String descricaoParam, String codParam) {
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

	private static Map<String, GenderEnum> map;

	static {
		map = new HashMap<>();
		for (GenderEnum v : GenderEnum.values())
			map.put(v.getCod(), v);
	}

	public static GenderEnum get(String sigla) {
		if (sigla == null)
			return null;

		return map.get(sigla.toUpperCase());
	}

}
