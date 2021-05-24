package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CursoAlunoDao;
import br.com.fiap.tds.dao.impl.CursoAlunoDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exercicio.entity.Aluno;
import br.com.fiap.tds.exercicio.entity.Curso;
import br.com.fiap.tds.exercicio.entity.CursoAluno;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Exercicio {
	
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um CursoAlunoDao
		CursoAlunoDao dao = new CursoAlunoDaoImpl(em);
		
		//Instanciar um aluno, curso e CursoAluno
		Aluno aluno = new Aluno("Sálvio");
		Curso curso = new Curso("Jardinagem");
		
		CursoAluno cursoAluno = 
				new CursoAluno(curso, aluno, Calendar.getInstance(), null, null);
		
		//Persistir o CursoAluno
		try {
			dao.create(cursoAluno);
			dao.commit();
			System.out.println("Tudo cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
