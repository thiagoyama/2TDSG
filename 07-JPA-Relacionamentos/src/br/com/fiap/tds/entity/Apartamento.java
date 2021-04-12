package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_APARTAMENTO")
@SequenceGenerator(name="ap", sequenceName = "SQ_TB_APARTAMENTO", allocationSize = 1)
public class Apartamento {
	
	@Id
	@Column(name="cd_apartamento")
	@GeneratedValue(generator = "ap", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_apartamento", nullable = false)
	private Integer numero;
	
	@Column(name="nr_capacidade")
	private Integer capacidade;
	
	@Column(name="vl_apartamento")
	private Double valor;
	
	//Mapeamento do relacionamento muitos para um
	@ManyToOne
	@JoinColumn(name="cd_hotel", nullable = false)
	private Hotel hotel;
	
	public Apartamento() {}
	
	public Apartamento(Integer numero, Integer capacidade, Double valor) {
		this.numero = numero;
		this.capacidade = capacidade;
		this.valor = valor;
	}

	public Apartamento(int codigo, Integer numero, Integer capacidade, Double valor) {
		this.codigo = codigo;
		this.numero = numero;
		this.capacidade = capacidade;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
