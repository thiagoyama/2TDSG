package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	//List<Cliente> listar();
	
	//Obter todos os clientes por parte do nome
	List<Cliente> listarPorNome(String nome);
	
	//Obter todos os clientes localizados por estado
	List<Cliente> listarPorEstado(String uf);
	
	//Obter os clientes que efetuaram a reserva em uma qtd de dias específica
	List<Cliente> listarPorDiasReserva(int dias);
	
	//Obter os clientes por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//Obter os clientes por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Obter os clientes por parte do nome sem considerar maiúsculas e minúsculas, ordenado por nome
	List<Cliente> buscarPorNome(String nome);
	
	//Contar a quantidade de clientes de um estado
	long contarPorEstado(String estado);
	
}