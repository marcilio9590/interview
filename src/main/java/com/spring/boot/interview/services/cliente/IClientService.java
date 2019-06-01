package com.spring.boot.interview.services.cliente;

import java.util.List;

import com.spring.boot.interview.dtos.ClientDTO;

public interface IClientService {

	public ClientDTO save(ClientDTO clienteParam);

	public List<ClientDTO> findByName(String clientName);

}
