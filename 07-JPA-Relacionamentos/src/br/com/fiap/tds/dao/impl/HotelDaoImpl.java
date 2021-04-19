package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.entity.Hotel;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

	public HotelDaoImpl(EntityManager em) {
		super(em);
	}

}
