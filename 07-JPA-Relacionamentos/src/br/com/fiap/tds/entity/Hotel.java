package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_HOTEL")
@SequenceGenerator(name="hotel", sequenceName = "SQ_TB_HOTEL", allocationSize = 1)
public class Hotel {
	
	@Id
	@Column(name="cd_hotel")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel")
	private int codigo;
	
	@Column(name="nm_hotel", nullable = false, length = 80)
	private String nome;
	
	@Column(name="ds_endereco", nullable = false, length = 100)
	private String endereco;
	
	//Mapeamento do relacionamento um-para-um
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_gerente", nullable = false)
	private Gerente gerente;
	
	//Mapeamento do relacionamento bidirecional um-para-muitos
	@OneToMany(mappedBy = "hotel")
	private List<Apartamento> apartamentos;

	public Hotel() {}

	public Hotel(String nome, String endereco, Gerente gerente) {
		this.nome = nome;
		this.endereco = endereco;
		this.gerente = gerente;
	}

	public Hotel(int codigo, String nome, String endereco, Gerente gerente) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.gerente = gerente;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
}
