package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Funcionario;

public class RefreshTeste {

	//Atualizar o objeto com os dados do banco
	public static void main(String[] args) {
		//Criar a fabrica e EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um funcionário de código 1
		Funcionario f = em.find(Funcionario.class, 1);
		
		//Exibir os dados do funcionário
		System.out.println(f);
		
		//Setar os valores dos atributos
		f.setCargo("Estágiario");
		f.setNome("Larissa");
		
		//Exibir os dados do funcionário
		System.out.println(f);
		
		//Refresh -> atualiza o objeto com os dados do banco
		em.refresh(f);
		
		//Exibir os dados do funcionário
		System.out.println(f);
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
