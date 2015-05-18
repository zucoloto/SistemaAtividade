package br.mil.eb.ccomsex.sistema.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.entity.Usuario;
import br.mil.eb.ccomsex.sistema.model.service.GrupoService;
import br.mil.eb.ccomsex.sistema.model.service.UsuarioService;
import br.mil.eb.ccomsex.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class UsuarioCadastrarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;
	@Inject
	private GrupoService grupoService;
	private Usuario usuario;
	private Long grupoSelecionado;
	private Grupo grupo;
	private List<Grupo> grupos;

	public UsuarioCadastrarBean() {
		limpar();
	}

	public void init() {
		carregarGrupo();
	}

	public void salvar() {
		this.usuario = usuarioService.salvar(this.usuario);
		limpar();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}

	public void adicionarGrupo() {
		if (this.usuario != null) {
			System.out.println(getGrupoSelecionado());
			grupo = grupoService.buscarPorId(getGrupoSelecionado());
			this.usuario.getGrupos().add(grupo);
			usuarioService.adicionarGrupo(this.usuario);
		}
	}

	public void carregarGrupo() {
		this.grupos = grupoService.listarTodos();
	}

	public void limpar() {
		usuario = new Usuario();
		grupos = new ArrayList<Grupo>();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(Long grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
