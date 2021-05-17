package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AGENCIA")
@SequenceGenerator(name="agencia", sequenceName = "SQ_TB_AGENCIA", allocationSize = 1)
public class Agencia {
	
	@Id
	@Column(name="nr_agencia")
	@GeneratedValue(generator="nm_agencia", strategy = GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="nm_agencia", length = 100, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;
	
	public Agencia() {}

	public Agencia(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	

}
