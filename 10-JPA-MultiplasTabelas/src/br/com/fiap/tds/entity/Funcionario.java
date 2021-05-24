package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)

@SecondaryTable(name = "TB_FUNCIONARIO_FINANCEIRO", 
							pkJoinColumns = @PrimaryKeyJoinColumn(name = "cd_funcionario"))

public class Funcionario {
	
	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", nullable = false, length = 80)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_contratacao", nullable = false)
	private Calendar dataContratacao;
	
	@Column(name="vl_salario", nullable = false, table = "TB_FUNCIONARIO_FINANCEIRO")
	private Double salario;
	
	@Column(name="nr_conta", nullable = false, table = "TB_FUNCIONARIO_FINANCEIRO")
	private Integer numeroConta;
	
	@Column(name="nr_agencia", nullable = false, table="TB_FUNCIONARIO_FINANCEIRO")
	private Integer numeroAgencia;
	
	public Funcionario() {}

	public Funcionario(String nome, Calendar dataContratacao, Double salario, Integer numeroConta,
			Integer numeroAgencia) {
		this.nome = nome;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Calendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
}
