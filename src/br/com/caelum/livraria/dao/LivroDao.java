package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.tx.Log;

public class LivroDao implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//EntityManager em;
	
	private DAO<Livro> dao;
	
	@Inject
	private EntityManager entityManager;
	@PostConstruct
	void init() {
		this.dao = new DAO<Livro>(this.entityManager, Livro.class);
	}
	@Log
	public void adiciona(Livro t) {
		dao.adiciona(t);
	}
	@Log
	public void atualiza(Livro t) {
		dao.atualiza(t);
	}
	@Log
	public Livro buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}
	@Log
	public int contaTodos() {
		return dao.contaTodos();
	}
	@Log
	public boolean equals(Object arg0) {
		return dao.equals(arg0);
	}
	@Log
	public void remove(Livro t) {
		dao.remove(t);
	}
	@Log
	public List<Livro> listaTodos() {
		return dao.listaTodos();
	}

	
	

	public List<Livro> listaTodosPaginada(int firstResult, int maxResults, String coluna, String valor) {
		return dao.listaTodosPaginada(firstResult, maxResults, coluna, valor);
	}

	
	
	
}
