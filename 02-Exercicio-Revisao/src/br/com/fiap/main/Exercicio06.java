package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	public static void main(String[] args) {
		// Instanciar uma conta corrente e conta poupança

		ContaCorrente cc = new ContaCorrente(
				1, 2, Calendar.getInstance(), 200, TipoConta.COMUM);

		ContaPoupanca cp = new ContaPoupanca(
				1, 22, new GregorianCalendar(2020, Calendar.MARCH, 8), 100, 0);
		
		try {
			cc.retirar(1000);
			System.out.println("Saque realizado!");
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}

	}// main

}// classe
