package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.dao.impl.CarroDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CarroDaoTeste {

	public static void main(String[] args) {
		//Obter uma instância do Entity Manager
		//EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		//EntityManager em = fabrica.createEntityManager();
		
		//Obter uma instância do CarroDao
		CarroDao dao = new CarroDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		//Cadastrar um carro
		Carro carro = new Carro("Gol", 2010);
		
		try {
			dao.create(carro);
			dao.commit();
			System.out.println("Carro registrado!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar o carro");
		}
		
		//Pesquisar um carro e exibir os dados
		try {
			carro = dao.findById(1);
			System.out.println(carro.getModelo() + " " + carro.getAno());
		} catch (EntityNotFoundException e) {
			System.out.println("Carro não encontrado!");
		}
		
		//Atualizar um carro
		carro = new Carro(1, "Celta", 2015);
		
		try {
			dao.update(carro);
			dao.commit();
			System.out.println("Carro atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um carro
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Carro removido!");
		} catch (EntityNotFoundException | CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		//em.close();
		//fabrica.close();
	}
	
}
