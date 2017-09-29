package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em; //

	private DAO<Autor> dao;

	@PostConstruct
	void init() {
		this.dao = new DAO<Autor>(this.em, Autor.class);
	}

	public Autor buscaPorId(Integer autorId) {
		return this.dao.buscaPorId(autorId);
	}

	public void adiciona(Autor t) {
		this.dao.adiciona(t);
	}

	public void atualiza(Autor t) {
		this.dao.atualiza(t);
	}

	public void remove(Autor t) {
		this.dao.remove(t);
	}

	public List<Autor> listaTodos() {
		return this.dao.listaTodos();
	}

}
