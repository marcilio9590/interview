package com.spring.boot.interview.services.cliente.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.enums.SexoEnum;
import com.spring.boot.interview.factories.ClientFactory;
import com.spring.boot.interview.models.ClientModel;
import com.spring.boot.interview.services.cliente.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientFactory factory;

	@Override
	public ClientDTO save(ClientDTO clienteParam) {
		return factory.entityToDto(new ClientModel());
	}

	@Override
	public List<ClientDTO> findByName(String clientName) {
		ClientModel c = new ClientModel();
		c.setName("Sandro da silva Junior");
		c.setGender(SexoEnum.MASCULINO);
		c.setDtBirth(new Date());
		List<ClientModel> lista = new ArrayList<ClientModel>();
		lista.add(c);
		return factory.listEntityToListDto(lista);
	}

}
