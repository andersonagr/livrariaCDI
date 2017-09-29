package br.com.caelum.livraria.modelo;

import java.util.Collections;
import java.util.List;
import java.util.Map;


import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.JPAUtil;

@SuppressWarnings("serial")
public class LivroDataModel extends LazyDataModel<Livro> {

	
	  private DAO<Livro> livroDAO;

	    public LivroDataModel() {
	        this.livroDAO = new DAO<Livro>(new JPAUtil().getEntityManager(), Livro.class);
	        super.setRowCount(livroDAO.quantidadeDeElementos());
	    }
	/*@Inject
	private LivroDao livrodao;

	@PostConstruct
	void init() {
		super.setRowCount(livrodao.contaTodos());

	}*/

	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao,
			Map<String, Object> filtros) {
		String genero = (String) filtros.get("genero");

		List<Livro> data = livroDAO.listaTodosPaginada(inicio, quantidade, "genero", genero);
		System.out.println(genero + inicio);
	
		// sort
		if (campoOrdenacao != null) {
			Collections.sort(data, new LazySorter(campoOrdenacao, sentidoOrdenacao));
		}

		return data;

	}
}
