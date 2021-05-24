package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@DiscriminatorValue("C")
@Table(name="TB_CASA")

//Nome da PK/FK da tabela TB_CASA
@PrimaryKeyJoinColumn(name="cd_casa")

@Entity
public class Casa extends Moradia {

	@Column(name="nr_andares")
	private Integer numeroAndares;
	
	@Column(name="st_quintal")
	private Boolean quintal;
	
	public Casa(){}

	public Casa(Integer numeroComodos, Float metrosQuadrados, String endereco, Integer numeroAndares, Boolean quintal) {
		super(numeroComodos, metrosQuadrados, endereco);
		this.numeroAndares = numeroAndares;
		this.quintal = quintal;
	}

	public Integer getNumeroAndares() {
		return numeroAndares;
	}

	public void setNumeroAndares(Integer numeroAndares) {
		this.numeroAndares = numeroAndares;
	}

	public Boolean isQuintal() {
		return quintal;
	}

	public void setQuintal(Boolean quintal) {
		this.quintal = quintal;
	}
	
}