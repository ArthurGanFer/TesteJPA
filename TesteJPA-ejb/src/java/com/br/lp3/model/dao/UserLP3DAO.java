/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.UserLP3;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31338283
 */
@Stateless
public class UserLP3DAO implements GenericDAO<UserLP3> {

    private EntityManager em;

    public UserLP3DAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LP3PU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(UserLP3 e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public List read() {
        Query query = em.createQuery("SELECT u FROM UserLP3 u", UserLP3.class);
        return query.getResultList();
    }

    @Override
    public UserLP3 readById(long id) {
        Query query = em.createQuery("SELECT u FROM UserLP3 u WHERE id_user = :id", UserLP3.class);
        query.setParameter("id", id);
        return (UserLP3) query.getSingleResult();
    }

    @Override
    public void update(UserLP3 e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    @Override
    public void delete(UserLP3 e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}
