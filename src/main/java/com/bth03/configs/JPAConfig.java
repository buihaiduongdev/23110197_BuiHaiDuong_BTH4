package com.bth03.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("dataSource");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
