package br.mil.eb.ccomsex.sistema.model.repository.infra;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.mil.eb.ccomsex.sistema.model.entity.Usuario;
import br.mil.eb.ccomsex.sistema.model.repository.UsuarioRepository;

public class UsuarioRepositoryJPA implements UsuarioRepository {

	@Inject
	private EntityManager em;

	@Override
	public Usuario salvar(Usuario usuario) {
		return em.merge(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		em.remove(usuario);
	}

	@Override
	public List<Usuario> listarTodos() {
		return em.createQuery("from Usuario order by nomeUsuario",
				Usuario.class).getResultList();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorNome(String nome) {
		try {
			return em
					.createQuery(
							"from Usuario where upper(nomeUsuario) = :nome",
							Usuario.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
