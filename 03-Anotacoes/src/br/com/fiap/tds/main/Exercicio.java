package br.com.fiap.tds.main;

import br.com.fiap.tds.model.Aluno;
import br.com.fiap.tds.model.Cliente;
import br.com.fiap.tds.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um Cliente e um Aluno
		Cliente cliente = new Cliente();
		Aluno aluno = new Aluno();
		
		//Instanciar um Orm
		Orm orm = new Orm();
		
		//Exibir a pesquisa para o aluno
		System.out.println(orm.gerarPesquisa(aluno));
		
		//Exibir a pesquisa para o cliente
		System.out.println(orm.gerarPesquisa(cliente));
	}
	
}
