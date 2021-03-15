package br.com.fiap.tds.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="TB_ALUNO")
//sequenceName -> nome da sequence no banco de dados
//name -> nome da sequence no Java, utilizado no "generator"
//allocationSize -> incremento da sequence
@SequenceGenerator(sequenceName = "SQ_TB_ALUNO",
								name = "seqAluno", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAluno")
	private int codigo;
	
	@Column(name="nm_aluno", nullable = false, length = 100)
	private String nome;

	@Column(name="nr_cpf", nullable = false, length = 12)
	private String cpf;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE) //Armazena somente a data no banco
	private Calendar dataNascimento;
	
	@Transient //Não é uma coluna no banco de dados
	private int idade;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", nullable = false)
	private Genero genero;

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}