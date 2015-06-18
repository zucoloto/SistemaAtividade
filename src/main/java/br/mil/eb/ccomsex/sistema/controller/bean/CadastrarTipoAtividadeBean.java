package br.mil.eb.ccomsex.sistema.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;
import br.mil.eb.ccomsex.sistema.model.service.TipoAtividadeService;
import br.mil.eb.ccomsex.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastrarTipoAtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtividadeService tipoAtividadeService;

	private TipoAtividade tipoAtividade;

	public CadastrarTipoAtividadeBean() {
		limpar();
	}

	public void inicializar() {

	}

	public void limpar() {
		tipoAtividade = new TipoAtividade();
	}

	public void salvar() {
		this.tipoAtividade = tipoAtividadeService.salvar(this.tipoAtividade);
		limpar();
		FacesUtil.addInfoMessage("Registro salvo com sucesso!");
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

}
