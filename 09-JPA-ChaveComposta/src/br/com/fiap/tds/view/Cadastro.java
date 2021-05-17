package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AgenciaDao;
import br.com.fiap.tds.dao.ContaDao;
import br.com.fiap.tds.dao.impl.AgenciaDaoImpl;
import br.com.fiap.tds.dao.impl.ContaDaoImpl;
import br.com.fiap.tds.entity.Agencia;
import br.com.fiap.tds.entity.Conta;
import br.com.fiap.tds.entity.ContaPK;
import br.com.fiap.tds.entity.TipoConta;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma AgenciaDao e Contao
		AgenciaDao agenciaDao = new AgenciaDaoImpl(em);
		ContaDao contaDao = new ContaDaoImpl(em);
		
		//Instanciar uma Agencia
		Agencia agencia = new Agencia("Virtual");
		
		//Instanciar uma Conta
		Conta conta = new Conta(agencia, 100, Calendar.getInstance(), TipoConta.SALARIO);
		
		//Cadastrar a agencia e conta
		agenciaDao.create(agencia);
		contaDao.create(conta);
		
		try {
			contaDao.commit();
			System.out.println("Conta e agencia cadastradas!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisa uma conta pela PK
			ContaPK pk = new ContaPK(1, 1);
			Conta contaBusca = contaDao.findById(pk);
			System.out.println(contaBusca.getAgencia().getNome());
		} catch (EntityNotFoundException e) {
			System.out.println("Conta não encontrada");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
