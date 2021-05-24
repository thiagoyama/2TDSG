package br.com.fiap.tds.exercicio.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//1 - Classe PK
//2 - @IdClass
//3 - @Id

@IdClass(CursoAlunoPK.class)

@Entity
@Table(name="TB_CURSO_ALUNO")
public class CursoAluno {

	@Id
	@ManyToOne
	@JoinColumn(name="cd_curso")
	private Curso curso;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_aluno")
	private Aluno aluno;
	
	@Column(name="dt_matricula", nullable = false)
	private Calendar data;
	
	@Column(name="vl_nota")
	private Float nota;
	
	@Column(name="st_aprovado")
	private Boolean aprovado;
	
	public CursoAluno() {}

	public CursoAluno(Curso curso, Aluno aluno, Calendar data, Float nota, Boolean aprovado) {
		super();
		this.curso = curso;
		this.aluno = aluno;
		this.data = data;
		this.nota = nota;
		this.aprovado = aprovado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
}
