package com.exemplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testeConnection {
   public static void main(String[] args) {
	
	 EntityManagerFactory emf = null;  
	 EntityManager em = null;
	 
	     try {
	    	 emf = Persistence.createEntityManagerFactory("HibernateJpaEbac");
	    	 em = emf.createEntityManager();
	    	 
	    	 System.out.println("[OK] conseguiu conecta no banco");
	    	 
	     } catch (Exception e) {
			System.err.println("[ERRO] nao conseguiu conecta no banco");
			e.printStackTrace();
		} finally {
			if( em != null && em.isOpen()) em.close();
			if( emf != null && emf.isOpen()) emf.close();
		}
	    
   }
}     
