/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanini.stefaninifood.controller;

import com.stefanini.stefaninifood.controller.exceptions.NonexistentEntityException;
import com.stefanini.stefaninifood.entity.Estabelecimento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author dmviana
 */
public class EstabelecimentoJpaController implements Serializable {

    public EstabelecimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estabelecimento estabelecimento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estabelecimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estabelecimento estabelecimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estabelecimento = em.merge(estabelecimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estabelecimento.getId();
                if (findEstabelecimento(id) == null) {
                    throw new NonexistentEntityException("The estabelecimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estabelecimento estabelecimento;
            try {
                estabelecimento = em.getReference(Estabelecimento.class, id);
                estabelecimento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estabelecimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(estabelecimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estabelecimento> findEstabelecimentoEntities() {
        return findEstabelecimentoEntities(true, -1, -1);
    }

    public List<Estabelecimento> findEstabelecimentoEntities(int maxResults, int firstResult) {
        return findEstabelecimentoEntities(false, maxResults, firstResult);
    }

    private List<Estabelecimento> findEstabelecimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Estabelecimento as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Estabelecimento findEstabelecimento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estabelecimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstabelecimentoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Estabelecimento as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
