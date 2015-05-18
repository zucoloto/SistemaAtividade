package br.mil.eb.ccomsex.sistema.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.sistema.model.entity.Usuario;
import br.mil.eb.ccomsex.sistema.model.service.UsuarioService;

@Named
@ViewScoped
public class UsuarioPesquisarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;
	private List<Usuario> usuarios;

	public void init() {
		pesquisar();
	}
	
	public void pesquisar() {
		usuarios = usuarioService.listarTodos();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
