package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema
			Sistema sistema = dao.findById(1);
			
			//Exibir o nome do sistema
			System.out.println(sistema.getNome());
			
			for (CasoTeste caso : sistema.getCasosTeste()) {
				System.out.println("\nCasos de teste:");
				//Exibir os casos de teste
				System.out.println(caso.getNome() + " - " + caso.getDescricao());
				
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println("Itens de teste:");
					//Exibir os itens de teste do caso de teste
					System.out.println(item.getDescricao());
					
					System.out.println("Usuários:");
					for (Usuario usuario : item.getUsuarios()) {
						//Exibir os usuários do item de teste
						System.out.println(usuario.getNome());
					}
				}
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe
