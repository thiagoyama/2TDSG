package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		
		//Instanciar um sistema
		Sistema sistema = new Sistema("Gerenciamento de vendas");

		//Instanciar dois casos de teste
		CasoTeste caso1 = new CasoTeste("Venda", "Realizar uma venda com sucesso");
		CasoTeste caso2 = new CasoTeste("Cobrança", "Realizar a cobrança através de boleto");
		
		//Adicionar os casos de testes no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		//Instanciar 3 itens de teste
		ItemTeste item1 = new ItemTeste("Venda com 3 itens diferenntes");
		ItemTeste item2 = new ItemTeste("Venda com 1 item");
		ItemTeste item3 = new ItemTeste("Cobrança com boleto");
		
		//Adicionar os itens nos casos de teste
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Instanciar 2 usuários
		Usuario usuario1 = new Usuario("giovanna");
		Usuario usuario2 = new Usuario("victor");
		
		//Criar uma lista de usuário e adiciona-los
		List<Usuario> users = new ArrayList<>();
		users.add(usuario1);
		users.add(usuario2);
		
		//Setar no item de teste
		item1.setUsuarios(users);
		item3.setUsuarios(users);
		
		//Cadastrar um sistema (o resto em cascata, arrumar a config para isso!)
		//EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um sistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Persistir o sistema
			dao.create(sistema);
			//Commit
			dao.commit();
			System.out.println("Tudo ok!");
		} catch (CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe