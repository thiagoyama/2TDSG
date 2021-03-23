package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Funcionario;

public class RemoveTeste {

	public static void main(String[] args) {
		//Criar a fabrica e o EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("sdf");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um funcionário pelo código
		Funcionario f = em.find(Funcionario.class, 1);
		
		//remover
		em.remove(f);
		
		//commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Funcionário removido!");
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
