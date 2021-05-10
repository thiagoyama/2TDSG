package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :t", Pacote.class);
		query.setParameter("t", transporte);
		return query.getResultList();
	}

	@Override
	public List<Object[]> listarPorPrecoMenor(float preco) {
		return em.createQuery("select p.descricao, p.dataSaida from Pacote p where p.preco < :valor", Object[].class)
				.setParameter("valor", preco)
				.getResultList();
	}

	@Override
	public List<Pacote> listarPorPrecoMenor2(float preco) {
		return em.createQuery("select new Pacote(p.descricao, p.dataSaida) from Pacote p where p.preco < :valor", Pacote.class)
				.setParameter("valor", preco)
				.getResultList();
	}

	@Override
	public List<String> listarPorPrecoMenor3(float preco) {
		return em.createQuery("select concat(p.descricao, upper(p.descricao)) from Pacote p where p.preco < :valor", String.class)
				.setParameter("valor", preco)
				.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

}
