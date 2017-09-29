package br.com.caelum.livraria.tx;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GerenciadorDeTransacao {

	@Inject
	EntityManager manager;

	public void executaTX() {

		// abre transacao
		manager.getTransaction().begin();
		
		//chamar DAO que precisa de TX
		

		// commita a transacao
		manager.getTransaction().commit();

	}
}
