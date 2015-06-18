package br.mil.eb.ccomsex.sistema.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;
import br.mil.eb.ccomsex.sistema.model.repository.TipoAtividadeRepository;

public class TipoAtividadeRepositoryJPA implements TipoAtividadeRepository,
		Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Override
	public TipoAtividade salvar(TipoAtividade tipoAtividade) {
		return em.merge(tipoAtividade);
	}

	@Override
	public void excluir(TipoAtividade tipoAtividade) {
		em.remove(tipoAtividade);
	}

	@Override
	public List<TipoAtividade> listarTodos() {
		return em.createQuery("from TipoAtividade", TipoAtividade.class)
				.getResultList();
	}

	@Override
	public TipoAtividade buscarPorId(Long id) {
		return em.find(TipoAtividade.class, id);
	}

}
