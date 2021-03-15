package br.com.fiap.tds.orm;

import br.com.fiap.tds.annotation.Tabela;

public class Orm {

	public String gerarPesquisa(Object obj) {
		//Recuperar a anotação @Tabela e obter o nome da tabela
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		String tabela = anotacao.nome();
		return "SELECT * FROM " + tabela;
	}
	
}