package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.entity.Apartamento;
import br.com.fiap.tds.entity.Hospede;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

	public static void main(String[] args) {
		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Obter um ApartamentoDao e um HotelDao
		HotelDao hotelDao = new HotelDaoImpl(em);

		// Definir e instanciar uma classe anônima -> filha de GenericDaoImpl
		GenericDao<Apartamento, Integer> apDao = new GenericDaoImpl<Apartamento, Integer>(em) {};
		GenericDao<Hospede, Integer> hospedeDao = new GenericDaoImpl<Hospede,Integer>(em){};
		
		// 1 - Cadastrar um apartamento com um hotel já cadastrado no banco
		// Pesquisar um hotel
		try {
			Hotel hotel = hotelDao.findById(1);
			
			// Instanciar um ap com o hotel
			Apartamento ap = new Apartamento(123, 4, 500.0);
			ap.setHotel(hotel);
			
			// Cadastrar o ap
			apDao.create(ap);
			apDao.commit();
			
			System.out.println("Apartamento registrado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// 2 - Cadastrar uma reserva de um apartamento e um hóspede já cadastrados no banco
		// Pesquisar um ap e uma hóspede
		try {
			Apartamento ap = apDao.findById(1);
			Hospede hospede = hospedeDao.findById(1);
			
			// Adicionar o hóspede no ap
			ap.getHospedes().add(hospede);
			
			// Update no ap
			apDao.update(ap);
			apDao.commit();
			
			System.out.println("Reserva registrada!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

	}//main

}//classe
