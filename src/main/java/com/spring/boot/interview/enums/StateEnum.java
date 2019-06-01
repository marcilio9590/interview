package com.spring.boot.interview.enums;

import java.util.HashMap;
import java.util.Map;

public enum StateEnum {
	AC("AC", "Acre"), AL("AL", "Alagoas"), AP("AP", "Amapá"), AM("AM", "Amazonas"), BA("BA", "Bahia"),
	CE("CE", "Ceará"), DF("DF", "Distrito Federal"), ES("ES", "Espírito Santo"), GO("GO", "Goiás"),
	MA("MA", "Maranhão"), MT("MT", "Mato Grosso"), MS("MS", "Mato Grosso do Sul"), MG("MG", "Minas Gerais"),
	PA("PA", "Pará"), PB("PB", "Paraíba"), PR("PR", "Paraná"), PE("PE", "Pernambuco"), PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"), RN("RN", "Rio Grande do Norte"), RS("RS", "Rio Grande do Sul"), RO("RO", "Rondônia"),
	RR("RR", "Roraima"), SC("RR", "Santa Catarina"), SP("SP", "São Paulo"), SE("SE", "Sergipe"), TO("TO", "Tocantins");

	private String sigla;
	private String nome;

	private StateEnum(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	private static Map<String, StateEnum> map;

	static {
		map = new HashMap<>();
		for (StateEnum v : StateEnum.values())
			map.put(v.name(), v);
	}

	public static StateEnum get(String sigla) {
		if (sigla == null)
			return null;

		return map.get(sigla.toUpperCase());
	}
}