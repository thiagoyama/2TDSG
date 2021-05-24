package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.CursoAlunoDao;
import br.com.fiap.tds.exercicio.entity.CursoAluno;
import br.com.fiap.tds.exercicio.entity.CursoAlunoPK;

public class CursoAlunoDaoImpl extends 
				GenericDaoImpl<CursoAluno, CursoAlunoPK> implements CursoAlunoDao {

	public CursoAlunoDaoImpl(EntityManager em) {
		super(em);
	}

}
