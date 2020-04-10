package com.pratian.project.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManager getEntityManager() {
		// Get Entity Manager Factory
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("test_jpql");
		
		// Get Entity Manager
		return factory.createEntityManager();
	}
	
	public static void closeEntityManager(EntityManager em) {
		em.close();
	}
}
