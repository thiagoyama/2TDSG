package br.com.fiap.tds.exercicio.entity;

import java.io.Serializable;

public class CursoAlunoPK implements Serializable {

	private int curso;
	
	private int aluno;
	
	public CursoAlunoPK() {}

	public CursoAlunoPK(int curso, int aluno) {
		this.curso = curso;
		this.aluno = aluno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aluno;
		result = prime * result + curso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoAlunoPK other = (CursoAlunoPK) obj;
		if (aluno != other.aluno)
			return false;
		if (curso != other.curso)
			return false;
		return true;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getAluno() {
		return aluno;
	}

	public void setAluno(int aluno) {
		this.aluno = aluno;
	}
	
}