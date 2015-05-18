package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.entity.Usuario;

public class UsuarioGrupoCadastro1 {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("MapaAtividadePU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario = manager.find(Usuario.class, 2L);
		System.out.println(usuario.getNomeUsuario());
		
		Grupo grupo = new Grupo();
		grupo = manager.find(Grupo.class, 2L);
		System.out.println(grupo.getNomeGrupo());

		usuario.getGrupos().add(grupo);

		manager.merge(usuario);

		trx.commit();
		manager.close();
	}
}
