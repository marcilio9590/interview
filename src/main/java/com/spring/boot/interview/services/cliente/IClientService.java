package com.spring.boot.interview.services.cliente;

import java.io.Serializable;
import java.util.List;

import com.spring.boot.interview.common.InvalidFieldException;
import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.dtos.UpdateClientDTO;

public interface IClientService extends Serializable {

	public ClientDTO save(ClientDTO clienteParam) throws InvalidFieldException;

	public List<ClientDTO> findByName(String clientName) throws InvalidFieldException;

	public ClientDTO findById(Long clientId) throws InvalidFieldException;

	public Boolean deleteById(Long clientId) throws InvalidFieldException;

	public ClientDTO updateName(UpdateClientDTO client) throws InvalidFieldException;

}
