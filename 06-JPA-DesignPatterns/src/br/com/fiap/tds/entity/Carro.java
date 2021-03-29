package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro {

	@Id
	@Column(name="cd_carro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private int codigo;
	
	@Column(name="ds_modelo", nullable = false, length = 50)
	private String modelo;
	
	@Column(name="nr_ano")
	private int ano;
	
	//CTRL + 3 -> gcuf
	public Carro() {}
	
	public Carro(String modelo, int ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}

	public Carro(int codigo, String modelo, int ano) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
