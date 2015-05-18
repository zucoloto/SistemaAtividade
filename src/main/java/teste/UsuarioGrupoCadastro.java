package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.entity.Usuario;

public class UsuarioGrupoCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("MapaAtividadePU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario.setNomeUsuario("Alessandro");
		usuario.setEmail("alessandro@gmail.com");
		usuario.setSenha("123");

		Grupo grupo = new Grupo();
		grupo.setNomeGrupo("Administrador");
		grupo.setDescricao("Administrador do Sistema");

		usuario.getGrupos().add(grupo);

		manager.persist(usuario);

		trx.commit();
		manager.close();
	}
}
