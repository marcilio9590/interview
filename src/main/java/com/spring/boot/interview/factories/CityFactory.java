package com.spring.boot.interview.factories;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.spring.boot.interview.dtos.CityDTO;
import com.spring.boot.interview.models.CityModel;

@Service
public class CityFactory {

	private ModelMapper modelMapper = new ModelMapper();

	/**
	 * Propósito: Converter uma entidade em um DTO que poderá ser exposto ao usuário
	 * desta API.
	 * 
	 * @param CityModel
	 * @return CityDTO
	 */
	public CityDTO entityToDto(CityModel CityModel) {
		return modelMapper.map(CityModel, CityDTO.class);
	}

	/**
	 * Propósito: Converter um DTO em uma entidade que poderá ser usada para salvar
	 * no banco de dados.
	 * 
	 * @param CityDTO
	 * @return CityModel
	 */
	public CityModel dtoToEntity(CityDTO CityDTO) {
		return modelMapper.map(CityDTO, CityModel.class);
	}

	public List<CityDTO> listEntityToListDto(List<CityModel> listCitiesModel) {
		java.lang.reflect.Type exit = new TypeToken<List<CityDTO>>() {
		}.getType();
		return modelMapper.map(listCitiesModel, exit);
	}

}
