package com.spring.boot.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.interview.models.ClientModel;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long> {

	@Query("select c from Cliente c where c.name like %?1%")
	List<ClientModel> findByName(String nome);

}
