package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Autor;

/**
 * Para transformar a classe AutorDao em um EJB basta uma configuração simples. 
 * Só precisamos anotá-la com @Stateless
 * O EJB Container irá registrar esse EJB dentro de um registro disponível no 
 *  servidor. 
 * O servidor usa por baixo dos panos esse registro JNDI para organizar os 
 *  componentes que ele administra. 
 * @author usertqi
 *
 */
@Stateless
public class AutorDao { 
	private Banco banco = new Banco();

	public void salva(Autor autor) {
		banco.save(autor);
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
