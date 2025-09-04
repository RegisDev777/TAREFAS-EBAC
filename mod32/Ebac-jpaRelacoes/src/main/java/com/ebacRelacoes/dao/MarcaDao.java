package com.ebacRelacoes.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ebacRelacoes.entidade.Marca;
import com.ebacRelacoes.jpaUtil.JPAUtil;

public class MarcaDao implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(marca);
            em.getTransaction().commit();
            return marca;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Marca buscaPorID(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Marca.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void ExcluirMarca(Marca marca) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Marca gerenciada = em.merge(marca);
            em.remove(gerenciada);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Marca alterarMarca(Marca marca) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Marca atualizada = em.merge(marca);
            em.getTransaction().commit();
            return atualizada;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Marca> buscarTodosMarca() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // JPQL usa o NOME DA ENTIDADE (Marca), não o nome da tabela (marca)
            return em.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
        } finally {
            em.close();
        }
    }
}
