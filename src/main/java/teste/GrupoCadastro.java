package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;

public class GrupoCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("MapaAtividadePU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Grupo grupo = new Grupo();
		grupo.setNomeGrupo("Administrador4");
		grupo.setDescricao("Administrador do Sistema4");
		
		manager.persist(grupo);

		trx.commit();
		manager.close();
	}
}
