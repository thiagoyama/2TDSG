package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1 -> solução rápida

public class ContaCorrente extends Conta {
	
	private TipoConta tipo;
	
	public ContaCorrente() {}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//Verificar se a conta é comum e o saldo fica negativo depois do saque
		if (tipo == TipoConta.COMUM && saldo - valor < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		saldo -=valor;
	}

	public TipoConta getTipo() {
		return tipo;
	}


	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
}