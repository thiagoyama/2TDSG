package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um Dao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Instanciar um funcionário
		Funcionario funcionario = new Funcionario("Allen",
			new GregorianCalendar(2010, Calendar.JANUARY, 10), 20000.0, 134, 12324);
		
		//Cadastrar um funcionário
		try {
			dao.create(funcionario);
			dao.commit();
			System.out.println("Funcionário cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		//Pesquisar um funcionário por PK
		try {
			Funcionario busca = dao.findById(1);
			System.out.println(busca.getNome() + " " + busca.getSalario());
		}catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}