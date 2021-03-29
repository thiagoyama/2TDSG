package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<E,K> implements GenericDao<E, K> {

	private EntityManager em;
	
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(E entidade) {
		em.persist(entidade);
	}

	@Override
	public E findById(K id) throws EntityNotFoundException {
		E entidade = em.find(E.class, id);
		if (entidade == null)
			throw new EntityNotFoundException();
		return entidade;
	}

	@Override
	public void update(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		E entidade = findById(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}