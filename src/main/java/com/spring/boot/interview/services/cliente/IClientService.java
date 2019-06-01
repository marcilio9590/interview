package com.spring.boot.interview.services.cliente;

import java.io.Serializable;
import java.util.List;

import com.spring.boot.interview.common.InterviewException;
import com.spring.boot.interview.dtos.ClientDTO;

public interface IClientService extends Serializable {

	public ClientDTO save(ClientDTO clienteParam) throws InterviewException;

	public List<ClientDTO> findByName(String clientName) throws InterviewException;

	public ClientDTO findById(Long clientId) throws InterviewException;

	public Boolean deleteById(Long clientId) throws InterviewException;

	public ClientDTO updateName(ClientDTO client) throws InterviewException;

}
