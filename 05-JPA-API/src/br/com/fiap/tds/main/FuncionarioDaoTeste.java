package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FuncionarioNaoEncontradoException;

public class FuncionarioDaoTeste {

	public static void main(String[] args) {
		//Instanciar um Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Cadastrar
		Funcionario f = new Funcionario("Giovanna", 
			new GregorianCalendar(2000, Calendar.JANUARY, 3), Genero.FEMININO, 
			"Analista Java", 4000);
		
		try {
			dao.create(f);
			dao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar
		try {
			f = dao.findById(1);
			System.out.println(f);
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar
		f = new Funcionario(1, "Kaue", new GregorianCalendar(1999, Calendar.APRIL, 1),
				Genero.MASCULINO, "Desenvolvedor Java", 5440);
		try {
			dao.update(f);
			dao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.delete(1);
			dao.commit();
		} catch(FuncionarioNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch(CommitException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
}
