package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Genero;

//View <-> Controller <-> DAO <-> BD

public class AtualizacaoTeste {

	//Atualizar um funcionário
	public static void main(String[] args) {
		//Instanciar uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Instanciar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instaciar um objeto Funcionário com um código que existe no banco (Estado : detached)
		Funcionario f = new Funcionario(1, "Vitor", 
				new GregorianCalendar(2001, Calendar.AUGUST, 10), 
				Genero.MASCULINO, "Desenvolvedor Pl", 6000);
		
		//Retorna uma cópia do funcionário no estado managed
		Funcionario f1 = em.merge(f);
		
		//Começa uma transação e commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Atualizado!");
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
