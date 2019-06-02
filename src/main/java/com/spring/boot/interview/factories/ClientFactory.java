package com.spring.boot.interview.factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.interview.common.ValidateUtil;
import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.enums.GenderEnum;
import com.spring.boot.interview.models.ClientModel;

@Service
public class ClientFactory {

	@Autowired
	private CityFactory cityFactory;

	/**
	 * Propósito: Converter uma entidade em um DTO que poderá ser exposto ao usuário
	 * desta API.
	 * 
	 * @param model
	 * @return ClientDTO
	 */
	public ClientDTO entityToDto(ClientModel model) {
		ClientDTO saida = new ClientDTO();
		saida.setId(model.getId());
		saida.setAge(model.getAge());
		if (!ValidateUtil.isEmptyOrNull(model.getCity())) {
			saida.setCity(cityFactory.entityToDto(model.getCity()));
		}
		saida.setDtBirth(dateToString(model.getDtBirth()));
		saida.setGender(model.getGender().getDescricao());
		saida.setName(model.getName());
		return saida;
	}

	/**
	 * Propósito: Converter um DTO em uma entidade que poderá ser usada para salvar
	 * no banco de dados.
	 * 
	 * @param clientDto
	 * @return ClientModel
	 */
	public ClientModel dtoToEntity(ClientDTO clientDto) {
		ClientModel saida = new ClientModel();
		saida.setId(clientDto.getId());
		if (!ValidateUtil.isEmptyOrNull(clientDto.getCity())) {
			saida.setCity(cityFactory.dtoToEntity(clientDto.getCity()));
		}
		saida.setAge(clientDto.getAge());
		saida.setDtBirth(stringToDate(clientDto.getDtBirth()));
		saida.setGender(GenderEnum.get(clientDto.getGender()));
		saida.setName(clientDto.getName());
		return saida;
	}

	public List<ClientDTO> listEntityToListDto(List<ClientModel> listClientsModel) {
		List<ClientDTO> saida = new ArrayList<ClientDTO>();
		for (ClientModel model : listClientsModel) {
			ClientDTO dto = new ClientDTO();
			dto.setId(model.getId());
			if (!ValidateUtil.isEmptyOrNull(model.getCity())) {
				dto.setCity(cityFactory.entityToDto(model.getCity()));
			}
			dto.setAge(model.getAge());
			dto.setDtBirth(dateToString(model.getDtBirth()));
			dto.setGender(model.getGender().getDescricao());
			dto.setName(model.getName());
			saida.add(dto);
		}
		return saida;
	}

	private String dateToString(Date source) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(source);
	}

	private Date stringToDate(String source) {
		Date exit = null;
		try {
			exit = new SimpleDateFormat("dd/MM/yyyy").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return exit;
	}
}
