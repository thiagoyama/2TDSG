package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.entity.Carro;

public class CarroDaoImpl 
		extends GenericDaoImpl<Carro, Integer> implements CarroDao {

	public CarroDaoImpl(EntityManager em) {
		super(em);
	}
	
}