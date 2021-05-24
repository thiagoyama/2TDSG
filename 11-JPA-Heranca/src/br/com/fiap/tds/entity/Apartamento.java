package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="TB_APARTAMENTO")

@Entity
public class Apartamento extends Moradia {

	@Column(name="nr_andar")
	private Integer andar;
	
	@Column(name="nr_apartamento")
	private Integer numero;
	
	public Apartamento() {}

	public Apartamento(Integer numeroComodos, Float metrosQuadrados, String endereco, Integer andar, Integer numero) {
		super(numeroComodos, metrosQuadrados, endereco);
		this.andar = andar;
		this.numero = numero;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
