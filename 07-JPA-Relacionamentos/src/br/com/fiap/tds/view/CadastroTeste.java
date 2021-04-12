package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GerenteDao;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.GerenteDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImp;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Gerente;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GerenteDao e um HotelDao
		//GerenteDao gerenteDao = new GerenteDaoImpl(em);
		HotelDao hotelDao = new HotelDaoImp(em);
		
		//Instanciar um gerente
		Gerente gerente = new Gerente("Eric", 3000.0, Genero.MASCULINO);
		
		//Instanciar um Hotel
		Hotel hotel = new Hotel("FIAP Hostel", "Av Paulista, 1000", gerente);
		
		//gerente.setHotel(hotel); //setar o hotel do gerente
		
		//Cadastrar um gerente
		//gerenteDao.create(gerente);

		//Cadastrar um hotel
		hotelDao.create(hotel);
		
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