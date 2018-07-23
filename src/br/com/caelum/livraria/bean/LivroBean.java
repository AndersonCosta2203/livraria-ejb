package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@Model
public class LivroBean {
	
	/*
	 * O DAO está sendo administrado pelo EJB Container. 
	 * Portanto, quem cria o DAO é o EJB Container e não a minha classe. 
	 * Consequentemente precisamos pedir ao EJB Container passar aquela instancia 
	 *  que ele está administrando.
	 * */
	
	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;
	
	private Livro livro = new Livro();
	
	private Integer autorId;
	

	public void cadastra() {
		
		Autor autor = this.autorDao.buscaPelaId(this.autorId);
		this.livro.setAutor(autor);
		
		this.livroDao.salva(livro);
		
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorDao.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroDao.todosLivros();
	}
}
