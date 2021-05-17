package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	//Buscar por código do cliente
	List<Reserva> buscarPorCodigoCliente(int codigo);
	
	//Buscar por data de saída do pacote
	List<Reserva> buscarPorDataSaida(Calendar inicio, Calendar fim);
	
}
