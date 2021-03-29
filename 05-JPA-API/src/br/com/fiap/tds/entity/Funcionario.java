package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_FUNCIONARIO")
@SequenceGenerator(name = "func", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name = "cd_funcionario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func")
	private int codigo;

	@Column(name = "nm_funcionario", length = 80, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero", length = 50)
	private Genero genero;

	@Column(name = "ds_cargo", length = 50)
	private String cargo;

	@CreationTimestamp // Cadastra a data e hora atual
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro", updatable = false)
	private Calendar dataCadastro;

	@Column(name = "vl_salario")
	private double salario;

	public Funcionario() {
	}

	public Funcionario(String nome, Calendar dataNascimento, 
							Genero genero, String cargo, double salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
	}

	// CTRL + 3 -> gcuf
	public Funcionario(int codigo, String nome, Calendar dataNascimento,
								Genero genero, String cargo, double salario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	//Método que executa automáticamente antes de cadastrar
	@PostPersist
	public void executar() {
		System.out.println("Executando...");
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return "Código: " + codigo + "\nNome: " + nome + "\nGenero: " +
				genero + "\nCargo: " + cargo + "\nSalário: " + salario + 
				"\nData Nascimento: " + formatador.format(dataNascimento.getTime()) +
				"\nData Cadastro: " + formatador.format(dataCadastro.getTime());
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}