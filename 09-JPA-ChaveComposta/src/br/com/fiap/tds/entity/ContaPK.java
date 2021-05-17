package br.com.fiap.tds.entity;

import java.io.Serializable;

//Classe que mapeia a chave composta da tabela TB_CONTA
public class ContaPK implements Serializable {

	private int numero;
	
	private int agencia;
	
	public ContaPK() {}

	public ContaPK(int numero, int agencia) {
		this.numero = numero;
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	//Implementação do hashCode() e equals() para terminar se um objeto ContaPK é igual ao outro
	//de acordo com os valores dos atributos (numero e agencia) e não se os objetos são iguais

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPK other = (ContaPK) obj;
		if (agencia != other.agencia)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
}