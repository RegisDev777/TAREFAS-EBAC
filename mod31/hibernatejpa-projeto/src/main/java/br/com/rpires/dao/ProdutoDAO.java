package br.com.rpires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.pires.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Produto cadastar(Produto p) {
		 EntityManagerFactory entityManagerFactory = 
				 Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 entityManager.persist(p);
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		
		return p;
	}
	@Override
	public Produto buscaPorID(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				Produto p = entityManager.find(Produto.class, id);
				entityManager.getTransaction().commit();
				
				entityManager.close();
				entityManagerFactory.close();
				
		return p;
	}
	@Override
	public void ExcluirProduto(Produto p) {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		  entityManager.getTransaction().begin();
		  p = entityManager.merge(p);
		  entityManager.remove(p);
		  entityManager.getTransaction().commit();
		  
		  entityManager.close();
		  entityManagerFactory.close();		
	}
	@Override
	public Produto alterarProduto(Produto p) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   entityManager.getTransaction().begin();
		   p = entityManager.merge(p);
		   entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return p;
	}
	@Override
	public List<Produto> buscarTodosProduto() {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJpaEbac");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 List<Produto> list = entityManager.createQuery("FROM Produto c", Produto.class).getResultList();
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
		 entityManagerFactory.close();
		 
		return list;
	}
	
	
	
	
}
