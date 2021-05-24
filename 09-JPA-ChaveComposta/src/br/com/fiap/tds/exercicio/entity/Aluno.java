package br.com.fiap.tds.exercicio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_aluno", nullable = false, length = 100)
	private String nome;
	
	@OneToMany(mappedBy = "aluno")
	private List<CursoAluno> cursoAlunos;
	
	public Aluno() {}

	public Aluno(String nome) {
		this.nome = nome;
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

	public List<CursoAluno> getCursoAlunos() {
		return cursoAlunos;
	}

	public void setCursoAlunos(List<CursoAluno> cursoAlunos) {
		this.cursoAlunos = cursoAlunos;
	}
	
}
