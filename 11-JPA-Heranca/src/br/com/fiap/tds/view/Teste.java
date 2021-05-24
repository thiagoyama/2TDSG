package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.MoradiaDao;
import br.com.fiap.tds.dao.impl.MoradiaDaoImpl;
import br.com.fiap.tds.entity.Apartamento;
import br.com.fiap.tds.entity.Casa;
import br.com.fiap.tds.entity.Moradia;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar a MoradiaDaoImpl
		MoradiaDao dao = new MoradiaDaoImpl(em);
	
		//Instanciar uma moradia, casa e ap
		Moradia moradia = new Moradia(3, 50f, "Rua Beija Flor, 29");
		
		Casa casa = new Casa(4, 80f, "Av Duque de caxias, 123", 1, false);
		
		Apartamento ap = new Apartamento(2, 25f, "Av Liberdade, 234", 4, 45);
		
		//Cadastrar as 3 entidades (Moradia, Casa e Apartamento)
		try {
			dao.create(moradia);
			dao.create(ap);
			dao.create(casa);
			dao.commit();
			System.out.println("Moradia, casa e ap cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}