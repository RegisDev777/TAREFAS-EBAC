package br.com.rpires.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.com.pires.domain.Matricula;

public class MatriculaDao implements IMatriculaDao{

	@Override
	public Matricula cadastrar(Matricula matricula) {
		 EntityManagerFactory entityManagerFactory = 
				 Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 entityManager.persist(matricula);
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		
		 return matricula;
	}

}
