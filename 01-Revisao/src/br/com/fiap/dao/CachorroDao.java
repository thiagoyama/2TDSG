package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Cachorro;

public interface CachorroDao {

	//Define as assinaturas dos métodos
	
	void cadastrar(Cachorro cachorro);
	
	List<Cachorro> listar(); 
	
}