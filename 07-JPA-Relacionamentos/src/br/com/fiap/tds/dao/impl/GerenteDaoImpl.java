package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.GerenteDao;
import br.com.fiap.tds.entity.Gerente;

public class GerenteDaoImpl 
					extends GenericDaoImpl<Gerente, Integer> implements GerenteDao{

	public GerenteDaoImpl(EntityManager em) {
		super(em);
	}

}
