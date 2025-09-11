package com.bth03.dao.impl;

import com.bth03.configs.JPAConfig;
import com.bth03.dao.UserDao;
import com.bth03.entity.User;
import com.bth03.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(String username, String password) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public User findById(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			em.close();
		}
	}

	public void update(User user) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
}
