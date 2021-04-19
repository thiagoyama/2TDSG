package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.entity.Apartamento;
import br.com.fiap.tds.entity.Hospede;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um Hotel Dao
		HotelDao dao = new HotelDaoImpl(em);
		
		//Pesquisar o hotel de código 1
		try {
			Hotel hotel = dao.findById(2);
		
			//Exibir o nome do hotel
			System.out.println("Hotel: " + hotel.getNome());
		
			//Exibir o nome do gerente
			System.out.println("Gerente : " + hotel.getGerente().getNome());
			
			//Exibir os apartamentos do hotel
			System.out.println("Apartamentos:");
			for (Apartamento ap : hotel.getApartamentos()) {
				System.out.println("Número: " + ap.getNumero() + 
						" R$ " + ap.getValor() + " Capacidade: " + ap.getCapacidade());
			
				//Exibir os hóspedes do apartamento
				System.out.println("Hóspedes:");
				for (Hospede hospede: ap.getHospedes()) {
					System.out.println("Nome: " + hospede.getNome());
				}
				
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().createEntityManager();
		
	}
	
}
