package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscarPorCodigoCliente(int codigo) {
		return em.createNamedQuery("Reserva.porCliente", Reserva.class)
				.setParameter("pId", codigo)
				.getResultList();
	}

	@Override
	public List<Reserva> buscarPorDataSaida(Calendar inicio, Calendar fim) {
		return em.createNamedQuery("Reserva.porDataSaida", Reserva.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

}
