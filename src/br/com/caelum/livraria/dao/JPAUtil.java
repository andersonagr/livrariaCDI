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
	@RequestScoped //produzir um entity manager a cada requição
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
//anotação @Disposes significa que ele avisa ao CDI que precisa fechar o entity manger após o fim da requisição
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
