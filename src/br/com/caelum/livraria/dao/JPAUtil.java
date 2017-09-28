package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	@Produces //antiga factory
	@RequestScoped //produzir um entity manager a cada requi��o
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
//anota��o @Disposes significa que ele avisa ao CDI que precisa fechar o entity manger ap�s o fim da requisi��o
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
