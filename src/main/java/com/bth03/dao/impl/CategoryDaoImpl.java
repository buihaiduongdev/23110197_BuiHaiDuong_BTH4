package com.bth03.dao.impl;

import java.util.List;

import com.bth03.configs.JPAConfig;
import com.bth03.dao.CategoryDao;
import com.bth03.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void insert(Category category) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(category);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Category category) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(category);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(int cateid) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			Category c = em.find(Category.class, cateid);
			if (c != null) {
				em.remove(c);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public Category findById(int cateid) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.find(Category.class, cateid);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Category> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Category> findByUserId(int userid) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.user.userid = :userid",
					Category.class);
			query.setParameter("userid", userid);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
