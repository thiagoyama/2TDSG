package br.com.fiap.main;

import br.com.fiap.bean.Cachorro;
import br.com.fiap.dao.CachorroDao;
import br.com.fiap.dao.CachorroOracleDao;


// View (JSP) <-> Controller (Servlet) CachorroDao <-> DAO <-> Banco de Dados

public class TesteInterface {
	
	public static void main(String[] args) {
		//Instanciar um CachorroOracleDao
		CachorroDao dao = new CachorroOracleDao();
		//Chamar o método cadastrar
		dao.cadastrar(new Cachorro(4,"Buldog Inglês"));
	}
	
}