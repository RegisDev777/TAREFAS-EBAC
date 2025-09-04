package com.ebacRelacoes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ebacRelacoes.entidade.Acessorio;
import com.ebacRelacoes.jpaUtil.JPAUtil;

public class AcessorioDao implements IAcessoriosDAO {

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(acessorio);
            em.getTransaction().commit();
            return acessorio;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Acessorio buscaPorID(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Acessorio.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void ExcluirAcessorio(Acessorio acessorio) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Acessorio gerenciado = em.merge(acessorio);
            em.remove(gerenciado);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Acessorio alterarAcessorio(Acessorio acessorio) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Acessorio atualizado = em.merge(acessorio);
            em.getTransaction().commit();
            return atualizado;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Acessorio> buscarTodosAcessorio() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Acessorio a", Acessorio.class)
                     .getResultList(); // JPQL usa o NOME DA ENTIDADE, não da tabela
        } finally {
            em.close();
        }
    }
}
