package br.mil.eb.ccomsex.sistema.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.sistema.model.entity.Usuario;

public interface UsuarioRepository {
	
	public Usuario salvar(Usuario usuario);

	public void excluir(Usuario usuario);

	public List<Usuario> listarTodos();

	public Usuario buscarPorId(Long id);
	
	public Usuario buscarPorNome(String nome);
	
}
