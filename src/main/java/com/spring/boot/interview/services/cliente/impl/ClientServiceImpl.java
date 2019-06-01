package com.spring.boot.interview.services.cliente.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.interview.common.InterviewException;
import com.spring.boot.interview.dtos.ClientDTO;
import com.spring.boot.interview.factories.ClientFactory;
import com.spring.boot.interview.models.ClientModel;
import com.spring.boot.interview.repositories.ClientRepository;
import com.spring.boot.interview.services.cliente.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	private static final long serialVersionUID = 2237970666017727580L;

	@Autowired
	private ClientFactory factory;

	@Autowired
	private ClientRepository repository;

	@Override
	@Transactional
	public ClientDTO save(ClientDTO clienteParam) throws InterviewException {
		ClientDTO entityToDto = null;
		try {
			entityToDto = factory.entityToDto(repository.save(factory.dtoToEntity(clienteParam)));
		} catch (Exception e) {
			System.out.println(e);
			throw new InterviewException(e);
		}
		return entityToDto;
	}

	@Override
	@Transactional
	public List<ClientDTO> findByName(String clientName) throws InterviewException {
		List<ClientDTO> exit = null;
		try {
			exit = factory.listEntityToListDto(repository.findByNome(clientName));
		} catch (Exception e) {
			System.out.println(e);
			throw new InterviewException(e);
		}
		return exit;
	}

	@Override
	@Transactional
	public ClientDTO findById(Long clientId) throws InterviewException {
		ClientDTO exit = null;
		try {
			Optional<ClientModel> model = repository.findById(clientId);
			if (model.isPresent()) {
				exit = factory.entityToDto(model.get());
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new InterviewException(e);
		}
		return exit;
	}

	@Override
	public Boolean deleteById(Long clientId) throws InterviewException {
		Boolean saida = Boolean.FALSE;
		try {
			repository.deleteById(clientId);
			saida = Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e);
			throw new InterviewException(e);
		}
		return saida;
	}

	@Override
	public ClientDTO updateName(ClientDTO client) throws InterviewException {
		return save(client);
	}

}
