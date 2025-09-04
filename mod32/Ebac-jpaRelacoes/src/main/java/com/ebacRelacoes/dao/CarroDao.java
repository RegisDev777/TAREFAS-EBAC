package com.ebacRelacoes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ebacRelacoes.entidade.Carro;


public class CarroDao implements ICarroDAO{

	@Override
	public Carro cadastrar(Carro carro) {
		 EntityManagerFactory entityManagerFactory = 
				 Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 entityManager.persist(carro);
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		
		return carro;
	}

	@Override
	public Carro buscaPorId(Long id) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaEbac");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();

	    Carro carro = em.createQuery(
	        "SELECT c FROM Carro c " +
	        "JOIN FETCH c.marca " +
	        "LEFT JOIN FETCH c.acessorios " +
	        "WHERE c.id = :id", Carro.class)
	      .setParameter("id", id)
	      .getSingleResult();

	    em.getTransaction().commit();
	    em.close();
	    emf.close();

	    return carro;
	}


	@Override
	public void excluirCarro(Carro carro) {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		  entityManager.getTransaction().begin();
		  carro = entityManager.merge(carro);
		  entityManager.remove(carro);
		  entityManager.getTransaction().commit();
		  
		  entityManager.close();
		  entityManagerFactory.close();
		
	}

	@Override
	public Carro alterarCarro(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   entityManager.getTransaction().begin();
		   carro = entityManager.merge(carro);
		   entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return carro;
	}

	@Override
	public List<Carro> BuscarTodosOsCarros() {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 List<Carro> list = entityManager.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		 
		return list;
	}

}
