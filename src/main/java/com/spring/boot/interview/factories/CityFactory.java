package com.spring.boot.interview.factories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.interview.dtos.CityDTO;
import com.spring.boot.interview.models.CityModel;

@Service
public class CityFactory {

	/**
	 * Propósito: Converter uma entidade em um DTO que poderá ser exposto ao usuário
	 * desta API.
	 * 
	 * @param CityModel
	 * @return CityDTO
	 */
	public CityDTO entityToDto(CityModel model) {
		CityDTO saida = new CityDTO();
		saida.setId(model.getId());
		saida.setName(model.getName());
		saida.setState(model.getState());
		return saida;
	}

	/**
	 * Propósito: Converter um DTO em uma entidade que poderá ser usada para salvar
	 * no banco de dados.
	 * 
	 * @param CityDTO
	 * @return CityModel
	 */
	public CityModel dtoToEntity(CityDTO dto) {
		CityModel saida = new CityModel();
		saida.setId(dto.getId());
		saida.setName(dto.getName());
		saida.setState(dto.getState());
		return saida;
	}

	public List<CityDTO> listEntityToListDto(List<CityModel> listModel) {
		List<CityDTO> saida = new ArrayList<CityDTO>();
		for (CityModel model : listModel) {
			CityDTO dto = new CityDTO();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setState(model.getState());
			saida.add(dto);
		}
		return saida;
	}

}
