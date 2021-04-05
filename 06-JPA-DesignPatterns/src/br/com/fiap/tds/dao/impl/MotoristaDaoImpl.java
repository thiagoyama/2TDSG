package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.MotoristaDao;
import br.com.fiap.tds.entity.Motorista;

public class MotoristaDaoImpl 
		extends GenericDaoImpl<Motorista, Integer> implements MotoristaDao {

	public MotoristaDaoImpl(EntityManager em) {
		super(em);
	}
	
}
