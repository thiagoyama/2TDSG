package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)

//Para a estratégia de SINGLE_TABLE -> altera o nome da coluna que define o tipo de objeto armazenado
//@DiscriminatorColumn(name = "ds_tipo")
//Define o valor que será gravado no banco 
//@DiscriminatorValue("M")

@Entity
@Table(name="TB_MORADIA")
@SequenceGenerator(name = "moradia", sequenceName = "SQ_TB_MORADIA", allocationSize = 1)
public class Moradia {
	
	@Id
	@Column(name="cd_moradia")
	@GeneratedValue(generator = "moradia", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_endereco", nullable = false, length = 100)
	private String endereco;
	
	@Column(name="nr_comodos")
	private Integer numeroComodos;
	
	@Column(name="nr_metros")
	private Float metrosQuadrados;
	
	public Moradia() {}
	
	public Moradia(Integer numeroComodos, Float metrosQuadrados, String endereco) {
		this.numeroComodos = numeroComodos;
		this.metrosQuadrados = metrosQuadrados;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroComodos() {
		return numeroComodos;
	}

	public void setNumeroComodos(Integer numeroComodos) {
		this.numeroComodos = numeroComodos;
	}

	public Float getMetrosQuadrados() {
		return metrosQuadrados;
	}

	public void setMetrosQuadrados(Float metrosQuadrados) {
		this.metrosQuadrados = metrosQuadrados;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
