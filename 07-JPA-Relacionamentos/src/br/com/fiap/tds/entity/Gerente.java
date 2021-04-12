package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GERENTE")
@SequenceGenerator(name="gerente", sequenceName = "SQ_TB_GERENTE", allocationSize = 1)
public class Gerente {

	@Id
	@Column(name="cd_gerente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerente")
	private int codigo;
	
	@Column(name="nm_gerente", nullable = false, length = 100)
	private String nome;
	
	@Column(name="vl_salario", nullable = false)
	private Double salario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private Genero genero;
	
	//Mapeamento do relacionamento um-para-um bidirecional
	//mappedBy -> nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "gerente", cascade = CascadeType.PERSIST)
	private Hotel hotel;

	public Gerente() {}

	public Gerente(String nome, Double salario, Genero genero) {
		this.nome = nome;
		this.salario = salario;
		this.genero = genero;
	}

	public Gerente(int codigo, String nome, Double salario, Genero genero) {
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
		this.genero = genero;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
