package br.com.rpires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pires.domain.Curso;

public class CursoDao implements ICursoDao {

	@Override
	public Curso cadastrar(Curso curso) {
		 EntityManagerFactory entityManagerFactory = 
				 Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 entityManager.persist(curso);
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		
		return curso;
	}
	@Override
	public Curso buscaPorID(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				Curso curso = entityManager.find(Curso.class, id);
				entityManager.getTransaction().commit();
				
				entityManager.close();
				entityManagerFactory.close();
				
		return curso;
	}
	@Override
	public void ExcluirCurso(Curso curso) {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		  entityManager.getTransaction().begin();
		  curso = entityManager.merge(curso);
		  entityManager.remove(curso);
		  entityManager.getTransaction().commit();
		  
		  entityManager.close();
		  entityManagerFactory.close();		
	}
	@Override
	public Curso alterarCurso(Curso curso) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   entityManager.getTransaction().begin();
		   curso = entityManager.merge(curso);
		   entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return curso;
	}
	@Override
	public List<Curso> buscarTodosCurso() {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 List<Curso> list = entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		 
		return list;
	}
	
	

}
