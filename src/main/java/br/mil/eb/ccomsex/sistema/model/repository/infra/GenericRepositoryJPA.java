package br.mil.eb.ccomsex.sistema.model.repository.infra;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class GenericRepositoryJPA<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Class<T> classe;

	@Inject
	protected EntityManager em;

	public GenericRepositoryJPA(Class<T> classe) {
		this.classe = classe;
	}

	public T salvar(T entity) {
		return em.merge(entity);
	}

	public void excluir(T entity) {
		em.remove(entity);
	}

	public T buscarPorId(Long id) {
		return em.find(classe, id);
	}

}
