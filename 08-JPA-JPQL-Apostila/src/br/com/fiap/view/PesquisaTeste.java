package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma CidadeDao
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Pesquisar todas as cidades
		List<Cidade> lista = cidadeDao.listar();
		
		//Exibir todas as cidades cadastradas
		for (Cidade cidade : lista) {
			System.out.println("\nNome: " + cidade.getNome() + " " + cidade.getUf());
			System.out.println("Nr Habitantes: " + cidade.getNrHabitantes());
		}
		
		//Exibir todas as cidades com ddd 11
		lista = cidadeDao.listarPorDdd(11);
		lista.forEach(c -> System.out.println(c.getNome()) );
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);

		//Exibir todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("\nClientes:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Exibir os clientes com nome que tenha a
		clientes = clienteDao.listarPorNome("Julio");
		System.out.println("\nClientes por parte do nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Exibir todos os pacotes do transporte 1
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> pacotes = pacoteDao.listarPorTransporte(transporte);
		System.out.println("\nPacotes por transporte:");
		pacotes.forEach(p -> System.out.println(p.getDescricao()));
		
		//Exibir todos os clientes do estado de PR
		clientes = clienteDao.listarPorEstado("PR");
		System.out.println("\nClientes por estado:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Exibir os clientes que possuem 10 dias de reserva
		clientes = clienteDao.listarPorDiasReserva(10);
		System.out.println("\nClientes por dias de reserva:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Exibir o segundo cliente encontrado até o quarto cliente
		//Primeiro registro -> posição 0
		System.out.println("\nListar clientes defindo o máximo e a posição");
		clienteDao.listar(1, 3).forEach(c -> System.out.println(c.getNome()));
		
		//Exibir os pacotes que possuem preço menor que 1000
		List<Object[]> pLista = pacoteDao.listarPorPrecoMenor(1000);
		System.out.println("\nListar pacotes por preço menor (Retornando objeto Object[])");
		pLista.forEach(p -> System.out.println(p[0] + " " + p[1]));
		
		//Exibir os pacotes que possuem preço menor que 1000
		pacotes = pacoteDao.listarPorPrecoMenor2(1000);
		System.out.println("\nListar pacotes por preço menor (Retornando objeto Pacote)");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias()));
		
		//Exibir a descrição dos pacotes que possuem preço menor que 1000
		List<String> pLista2 = pacoteDao.listarPorPrecoMenor3(1000);
		System.out.println("\nListar as descrições dos pacotes por preço menor:");
		pLista2.forEach(p -> System.out.println(p));
		
		//Obter os pacotes que possuem a data de saída no intervalo
		Calendar dataInicio = new GregorianCalendar(2020, Calendar.AUGUST, 30);
		Calendar dataFim = Calendar.getInstance(); //Obtem a data atual
		pacotes = pacoteDao.buscarPorDatas(dataInicio, dataFim);
		System.out.println("\nBuscar pacotes por data de saída:");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Obter os clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Sal");
		System.out.println("\nBuscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Obter os clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("BA");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("\nBuscar clientes por estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Obter os clientes por parte do nome, ordenado por nome, sem case sensitive
		clientes = clienteDao.buscarPorNome("leandro");
		System.out.println("Buscar clientes por nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
