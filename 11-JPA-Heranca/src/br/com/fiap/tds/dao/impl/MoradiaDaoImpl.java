package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.MoradiaDao;
import br.com.fiap.tds.entity.Moradia;

public class MoradiaDaoImpl extends GenericDaoImpl<Moradia, Integer> implements MoradiaDao {

	public MoradiaDaoImpl(EntityManager em) {
		super(em);
	}

}
