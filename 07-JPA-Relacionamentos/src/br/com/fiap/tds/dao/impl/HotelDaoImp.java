package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.entity.Hotel;

public class HotelDaoImp extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

	public HotelDaoImp(EntityManager em) {
		super(em);
	}

}
