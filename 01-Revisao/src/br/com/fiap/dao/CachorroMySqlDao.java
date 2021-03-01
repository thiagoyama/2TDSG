package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Cachorro;

public class CachorroMySqlDao implements CachorroDao {

	@Override
	public void cadastrar(Cachorro cachorro) {
		System.out.println("Cadastrando no MySql");
	}

	@Override
	public List<Cachorro> listar() {
		System.out.println("Pesquisando do MySql");
		return null;
	}

}