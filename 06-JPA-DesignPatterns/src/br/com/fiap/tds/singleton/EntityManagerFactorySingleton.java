package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a única instância da fabrica de entity manager
 */
public class EntityManagerFactorySingleton {

	//Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	//Construtor privado -> não pode -> new EntityManagerFactorySingleton();
	private EntityManagerFactorySingleton() {}
	
	//Método estático que retorna a única instância
	public static EntityManagerFactory getInstance() {
		//Validar se existe uma instância da fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}