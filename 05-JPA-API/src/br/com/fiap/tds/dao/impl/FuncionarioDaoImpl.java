package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;

//View - Controller - DAO - Banco

public class FuncionarioDaoImpl implements FuncionarioDao {

	private EntityManager em;
	
	public FuncionarioDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(Funcionario func) {
		em.persist(func);
	}

	@Override
	public Funcionario findById(int codigo) throws FuncionarioNaoEncontradoException {
		Funcionario func = em.find(Funcionario.class, codigo);
		if (func == null)
			throw new FuncionarioNaoEncontradoException();
		return func;
	}

	@Override
	public void update(Funcionario func) {
		em.merge(func);
	}

	@Override
	public void delete(int codigo) throws FuncionarioNaoEncontradoException {
		Funcionario func = findById(codigo);
		em.remove(func);
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