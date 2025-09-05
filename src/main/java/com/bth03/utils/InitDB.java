package com.bth03.utils;

import com.bth03.configs.JPAConfig;
import com.bth03.entity.Category;
import com.bth03.entity.User;

import jakarta.persistence.EntityManager;

public class InitDB {
	public static void init() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();

			long count = (long) em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
			if (count == 0) {
				// Thêm user mẫu
				User user1 = new User();
				user1.setUsername("user1");
				user1.setPassword("123");
				user1.setRoleid(1);

				User manager1 = new User();
				manager1.setUsername("manager1");
				manager1.setPassword("123");
				manager1.setRoleid(2);

				User admin1 = new User();
				admin1.setUsername("admin1");
				admin1.setPassword("123");
				admin1.setRoleid(3);

				em.persist(user1);
				em.persist(manager1);
				em.persist(admin1);

				// Thêm category mẫu
				Category c1 = new Category();
				c1.setCatename("Phim hành động");
				c1.setIcon("icon1.png");
				c1.setUser(user1);

				Category c2 = new Category();
				c2.setCatename("Quản lý kho");
				c2.setIcon("icon2.png");
				c2.setUser(manager1);

				Category c3 = new Category();
				c3.setCatename("Hệ thống admin");
				c3.setIcon("");
				c3.setUser(admin1);

				em.persist(c1);
				em.persist(c2);
				em.persist(c3);
			}

			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
