package br.com.fiap.tds.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.model.Cliente;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um Cliente
		Cliente cliente = new Cliente();
		
		//API de Reflection -> obtem a estrutura da classe
		//Exibir o nome da classe:
		System.out.println(cliente.getClass().getName());
		
		//Recuperar os atributos da classe
		Field[] atributos = cliente.getClass().getDeclaredFields();
		//Exibir os atributos da classe cliente:
		for (Field a : atributos) {
			System.out.println(a.getName());
			//Recuperar a anotação @Coluna
			Coluna anotacao = a.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome() + " " + anotacao.obrigatorio());
		}
		
		//Recuperar os métodos da classe
		Method[] metodos = cliente.getClass().getDeclaredMethods();
		//Exibir os métodos da classe
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
	}//main
	
}//classe