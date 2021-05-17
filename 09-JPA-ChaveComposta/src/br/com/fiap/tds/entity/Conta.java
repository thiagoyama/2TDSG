package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Indica que a conta PK é a classe que mapeia as PKs da Conta
@IdClass(ContaPK.class)

@Entity
@Table(name="TB_CONTA")
@SequenceGenerator(name="conta", sequenceName = "SQ_TB_CONTA", allocationSize = 1)
public class Conta {

	@Id
	@Column(name="nr_conta")
	@GeneratedValue(generator = "conta", strategy = GenerationType.SEQUENCE)
	private int numero;
	
	@Id
	@ManyToOne
	@JoinColumn(name="nr_agencia")
	private Agencia agencia;
	
	@Column(name="vl_saldo", nullable = false)
	private double saldo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura", nullable = false)
	private Calendar dataAbertura;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private TipoConta tipo;
	
	public Conta() {}

	public Conta(Agencia agencia, double saldo, Calendar dataAbertura, TipoConta tipo) {
		this.agencia = agencia;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
}
