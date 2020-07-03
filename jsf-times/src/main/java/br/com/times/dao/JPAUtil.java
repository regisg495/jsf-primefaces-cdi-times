package br.com.times.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private final EntityManagerFactory mf = Persistence.createEntityManagerFactory("times");

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return mf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		em.close();
	}

}
