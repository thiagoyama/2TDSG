package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.entity.Funcionario;

public class FuncionarioDaoImpl 
				extends GenericDaoImpl<Funcionario, Integer> implements FuncionarioDao {

	public FuncionarioDaoImpl(EntityManager em) {
		super(em);
	}

}
