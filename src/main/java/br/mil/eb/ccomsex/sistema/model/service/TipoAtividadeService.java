package br.mil.eb.ccomsex.sistema.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;
import br.mil.eb.ccomsex.sistema.model.repository.TipoAtividadeRepository;
import br.mil.eb.ccomsex.sistema.util.jpa.Transactional;

public class TipoAtividadeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtividadeRepository tipoAtividadeRepository;

	@Transactional
	public TipoAtividade salvar(TipoAtividade tipoAtividade) {
		return tipoAtividadeRepository.salvar(tipoAtividade);
	}

	@Transactional
	public void excluir(TipoAtividade tipoAtividade) {
		tipoAtividadeRepository.excluir(tipoAtividade);
	}

	public List<TipoAtividade> listarTodos() {
		return tipoAtividadeRepository.listarTodos();
	}

	public TipoAtividade buscarPorId(Long id) {
		return tipoAtividadeRepository.buscarPorId(id);
	}

}
