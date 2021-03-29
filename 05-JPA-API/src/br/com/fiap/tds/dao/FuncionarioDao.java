package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;

// View - Controller FuncionarioDao - DAO - Banco

public interface FuncionarioDao {

	void create(Funcionario func);
	
	Funcionario findById(int codigo) throws FuncionarioNaoEncontradoException ;
	
	void update(Funcionario func);
	
	void delete(int codigo) throws FuncionarioNaoEncontradoException;
	
	void commit() throws CommitException;
	
}