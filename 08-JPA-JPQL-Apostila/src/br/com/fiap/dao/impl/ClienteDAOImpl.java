package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listarPorNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :n", Cliente.class);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstado(String uf) {
		TypedQuery<Cliente> query = em.createQuery
				("from Cliente c where c.endereco.cidade.uf = :p", Cliente.class);
		query.setParameter("p", uf);
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorDiasReserva(int dias) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r where r.numeroDias = :p", Cliente.class);
		query.setParameter("p", dias);
		return query.getResultList();
	}

	/*
	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
	*/
}
