package br.mil.eb.ccomsex.sistema.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.service.GrupoService;

@Named
@ViewScoped
public class GrupoPesquisarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;
	private List<Grupo> grupos;

	public void init() {
		pesquisar();
	}

	public void pesquisar() {
		grupos = grupoService.listarTodos();
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
