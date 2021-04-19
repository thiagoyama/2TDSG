package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GerenteDao;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.GerenteDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.entity.Apartamento;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Gerente;
import br.com.fiap.tds.entity.Hospede;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GerenteDao e um HotelDao
		GerenteDao gerenteDao = new GerenteDaoImpl(em);
		HotelDao hotelDao = new HotelDaoImpl(em);
		
		//Instanciar um gerente
		Gerente gerente = new Gerente("Eric", 3000.0, Genero.MASCULINO);
		
		//Instanciar um Hotel
		Hotel hotel = new Hotel("FIAP Hostel", "Av Paulista, 1000", gerente);
		
		gerente.setHotel(hotel); //setar o hotel do gerente
		
		//Instanciar 3 apartamentos e adicionar no hotel
		Apartamento ap1 = new Apartamento(12, 4, 100.0);
		Apartamento ap2 = new Apartamento(34, 6, 300.0);
		Apartamento ap3 = new Apartamento(40, 2, 150.0);
		
		hotel.addApartamento(ap1);
		hotel.addApartamento(ap2);
		hotel.addApartamento(ap3);
		
		//Instanciar 2 hospedes
		Hospede hospede1 = new Hospede("Eric", "123434234234", Genero.MASCULINO);
		Hospede hospede2 = new Hospede("Giovanna","1230993490", Genero.FEMININO);
		
		//Instanciar uma lista de hóspedes e adiciona-los na lista
		List<Hospede> hospedes = new ArrayList<>();
		hospedes.add(hospede1);
		hospedes.add(hospede2);
		
		//Setar os hospedes no ap
		ap1.setHospedes(hospedes);
		ap2.setHospedes(hospedes);
		
		//Cadastrar um gerente
		gerenteDao.create(gerente);

		//Cadastrar um hotel
		//hotelDao.create(hotel);
		
		try {
			hotelDao.commit();
			//gerenteDao.commit();
			System.out.println("Gerente e hotel registrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}