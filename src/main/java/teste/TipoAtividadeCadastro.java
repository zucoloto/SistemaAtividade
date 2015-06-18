package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;

public class TipoAtividadeCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		TipoAtividade tp = new TipoAtividade();
		tp.setNomeAtividade("Desenvolvimento de Sistema Fale Conosco");
		tp.setPeriodico("Extra");
		tp.setPop("POP");
		
		manager.persist(tp);
		trx.commit();
		manager.close();

	}

}
