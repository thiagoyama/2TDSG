package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_HOSPEDE")
@SequenceGenerator(name="hospede", sequenceName = "SQ_TB_HOSPEDE", allocationSize = 1)
public class Hospede {

	@Id
	@Column(name="cd_hospede")
	@GeneratedValue(generator = "hospede", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_hospede", nullable = false, length = 100)
	private String nome;
	
	@Column(name="nr_cpf", nullable = false, length = 16)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20, nullable = false)
	private Genero genero;
	
	//Mapeamento do relacionamento muitos-para-muitos bidirecional
	@ManyToMany(mappedBy = "hospedes")
	private List<Apartamento> apartamentos;

	public Hospede() {}

	public Hospede(String nome, String cpf, Genero genero) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
	}

	public Hospede(int codigo, String nome, String cpf, Genero genero) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
	
}
