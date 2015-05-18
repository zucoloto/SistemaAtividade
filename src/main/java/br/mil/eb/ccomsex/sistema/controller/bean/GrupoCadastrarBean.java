package br.mil.eb.ccomsex.sistema.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.service.GrupoService;
import br.mil.eb.ccomsex.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class GrupoCadastrarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;
	private Grupo grupo;

	public GrupoCadastrarBean() {
		limpar();
	}

	public void salvar() {
		this.grupo = grupoService.salvar(this.grupo);
		limpar();
		FacesUtil.addInfoMessage("Grupo salvo com sucesso!");
	}

	private void limpar() {
		grupo = new Grupo();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
