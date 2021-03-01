package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Cachorro;

public class CachorroOracleDao implements CachorroDao {

	@Override
	public void cadastrar(Cachorro cachorro) {
		System.out.println("Cadastrando no banco oracle...");
	}

	@Override
	public List<Cachorro> listar() {
		System.out.println("Listando do banco oracle...");
		return null;
	}

}