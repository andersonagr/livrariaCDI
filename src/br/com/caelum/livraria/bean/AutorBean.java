package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Named
@ViewScoped // javax.faces.view.viewScoped
public class AutorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Autor autor = new Autor();
	
	@Inject
	private AutorDao autordao; //CDI faz new AutorDao() e injeta 

	

	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = this.autordao.buscaPorId(autorId);
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			this.autordao.adiciona(this.autor);
		} else {
			this.autordao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "autor?faces-redirect=true";
	}

	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		this.autordao.remove(autor);
	}

	public List<Autor> getAutores() {
		return this.autordao.listaTodos();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
