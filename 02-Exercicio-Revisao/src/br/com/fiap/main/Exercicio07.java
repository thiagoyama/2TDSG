package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		
		//Criar uma lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas
		lista.add(new ContaCorrente(1, 3, Calendar.getInstance(), 1000, TipoConta.ESPECIAL));
		lista.add(new ContaCorrente(2,34, Calendar.getInstance(), 9000, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(3,3, Calendar.getInstance(), 900, TipoConta.COMUM));
		
		//Exibir o saldo das contas
		for (Conta c : lista) {
			System.out.println(c.getSaldo());
		}
		
	}
	
}