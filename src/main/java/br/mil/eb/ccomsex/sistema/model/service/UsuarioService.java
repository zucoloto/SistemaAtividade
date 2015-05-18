package br.mil.eb.ccomsex.sistema.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.sistema.model.entity.Usuario;
import br.mil.eb.ccomsex.sistema.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.sistema.model.service.exception.NegocioException;
import br.mil.eb.ccomsex.sistema.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarios;

	// @Transactional
	// public Usuario salvar(Usuario usuario) {
	// return usuarios.salvar(usuario);
	// }

	@Transactional
	public Usuario salvar(Usuario usuario) {

		Usuario usuarioExistente = usuarios.buscarPorNome(usuario
				.getNomeUsuario());

		if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Usuário informado já cadastrado.");
		}

		return usuarios.salvar(usuario);

	}

	@Transactional
	public Usuario adicionarGrupo(Usuario usuario) {
		return usuarios.salvar(usuario);
	}

	public List<Usuario> listarTodos() {
		return usuarios.listarTodos();
	}
}
