package br.mil.eb.ccomsex.sistema.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;

public interface TipoAtividadeRepository {

	public TipoAtividade salvar(TipoAtividade tipoAtividade);

	public void excluir(TipoAtividade tipoAtividade);

	public List<TipoAtividade> listarTodos();

	public TipoAtividade buscarPorId(Long id);
}
