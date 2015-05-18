package br.mil.eb.ccomsex.sistema.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.sistema.model.entity.Fracao;

public class Fracoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Fracao buscarPorId(Long id) {
		return em.find(Fracao.class, id);
	}

	public List<Fracao> buscarFracaoRaiz() {
		return em.createQuery("from Fracao", Fracao.class).getResultList();
	}
}