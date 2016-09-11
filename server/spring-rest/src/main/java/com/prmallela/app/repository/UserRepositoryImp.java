package com.prmallela.app.repository;


import com.prmallela.app.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }

    @Override
    public User findOne(String uid) {
        return em.find(User.class, uid);
    }

    @Override
    public List<User> findByFirstName(String firstname) {
        TypedQuery<User> query = em.createNamedQuery("User.findByFirstName", User.class);
        query.setParameter("pfirstname", firstname);
        List<User> users = query.getResultList();
        if (users == null) {
            return null;
        }
        return users;
    }

    @Override
    public List<User> findByLastName(String lastname) {
        TypedQuery<User> query = em.createNamedQuery("User.findByLastName", User.class);
        query.setParameter("pfirstname", lastname);
        List<User> users = query.getResultList();
        if (users == null) {
            return null;
        }
        return users;
    }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("pfirstname", email);
        User users = query.getSingleResult();
        if (users == null) {
            return null;
        }
        return users;
    }

    @Override
    public User Create(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }

    @Override
    public void remove(User user) {
        em.remove(user);

    }
}
