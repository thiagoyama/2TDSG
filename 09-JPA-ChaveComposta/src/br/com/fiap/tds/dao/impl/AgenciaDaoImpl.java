package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.AgenciaDao;
import br.com.fiap.tds.entity.Agencia;

public class AgenciaDaoImpl extends GenericDaoImpl<Agencia, Integer> implements AgenciaDao {

	public AgenciaDaoImpl(EntityManager em) {
		super(em);
	}

}
