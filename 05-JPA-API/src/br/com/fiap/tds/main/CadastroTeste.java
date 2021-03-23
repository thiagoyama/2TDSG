package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Genero;

public class CadastroTeste {

	//Cadastrar um funcionário
	public static void main(String[] args) {
		
		//Criar a fabrica (EntityManagerFactory)
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		//Criar um EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um funcionário sem o código (Estado: new, não gerenciado)
		Funcionario f = new Funcionario("Rodrigo", 
				new GregorianCalendar(2000, Calendar.MARCH, 29),
					Genero.MASCULINO, "Analista Dev Pl.", 5500);
		
		//Entity manager começa a gerenciar o objeto (Estado: managed)
		em.persist(f);
		
		//Abrir uma transação
		em.getTransaction().begin();
		//Commit
		em.getTransaction().commit();
		
		System.out.println("Funcionário cadastrado!");
		
//		f.setCargo("Gerente");
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
		
	}
	
}