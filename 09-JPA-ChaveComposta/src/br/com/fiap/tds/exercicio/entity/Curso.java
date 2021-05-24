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
@Table(name="TB_CURSO")
@SequenceGenerator(name="curso", sequenceName = "SQ_TB_CURSO", allocationSize = 1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator = "curso", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso", nullable = false, length = 100)
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<CursoAluno> cursoAlunos;

	public Curso() {}
	
	public Curso(String nome) {
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
