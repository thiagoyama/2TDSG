package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	//Obter os pacotes por um transporte específico
	List<Pacote> listarPorTransporte(Transporte transporte);
	
}
