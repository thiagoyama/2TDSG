package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer> {
	
	//Obter pacotes por parte da descrição e data de saída maior
	//Utilizando query nativa
	List<Pacote> listarPorDescricaoEDataSaidaMaiorAtual(String descricao);

	//Obter os pacotes por um transporte específico
	List<Pacote> listarPorTransporte(Transporte transporte);
	
	//Obter os pacotes com preço menor que o valor, retornando a descricao e data saida
	// lista.get(0) -> Object[] -> [descricao, dataSaida]
	List<Object[]> listarPorPrecoMenor(float preco);
	
	//Obter os pacotes com preço menor que o valor, retornando a descricao e data saida no objeto Pacote
	List<Pacote> listarPorPrecoMenor2(float preco);
	
	//Obter os pacotes com preço menor que o valor, retornando a descricao
	List<String> listarPorPrecoMenor3(float preco);
	
	//Obter os pacotes que possuem a data de saída no intervalo dos parâmetros
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	//Somar os preços por um transporte
	double somarPorTransporte(Transporte transporte);
	
}

