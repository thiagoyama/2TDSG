package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Funcionario;

public class PesquisaTeste {

	//Pesquisar um funcionário pela PK
	public static void main(String[] args) {
		
		//Instanciar uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Instanciar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisa um funcionário pela PK (código) (Estado: managed)
		Funcionario f = em.find(Funcionario.class, 1);
		
		//Exibir os dados do funcionário
		System.out.println(f);
		
		//Alterar o valor do nome
		f.setNome("Eric");
		
		//Começar uma transação
		em.getTransaction().begin();
		//Commit
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
