package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.HotelDaoImp;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um Hotel Dao
		HotelDao dao = new HotelDaoImp(em);
		
		//Pesquisar o hotel de código 1
		try {
			Hotel hotel = dao.findById(1);
		
			//Exibir o nome do hotel
			System.out.println(hotel.getNome());
		
			//Exibir o nome do gerente
			//System.out.println(hotel.getGerente().getNome());
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().createEntityManager();
		
	}
	
}
