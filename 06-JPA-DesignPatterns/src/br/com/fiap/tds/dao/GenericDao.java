package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

//GenericDao<Motorista, String>

public interface GenericDao<E,K> {

	void create(E entidade);
	
	E findById(K id) throws EntityNotFoundException;
	
	void update(E entidade);
	
	void delete(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}