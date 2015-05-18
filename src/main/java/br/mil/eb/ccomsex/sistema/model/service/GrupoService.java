package br.mil.eb.ccomsex.sistema.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.repository.GrupoRepository;
import br.mil.eb.ccomsex.sistema.util.jpa.Transactional;

public class GrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoRepository grupos;

	@Transactional
	public Grupo salvar(Grupo grupo) {
		return grupos.salvar(grupo);
	}

	public Grupo buscarPorId(Long id) {
		return grupos.buscarPorId(id);
	}

	public List<Grupo> listarTodos() {
		return grupos.listarTodos();
	}
}
