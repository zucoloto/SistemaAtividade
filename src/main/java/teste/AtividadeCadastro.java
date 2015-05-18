package teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.Atividade;
import br.mil.eb.ccomsex.sistema.model.entity.Fracao;
import br.mil.eb.ccomsex.sistema.model.entity.StatusAtividade;

public class AtividadeCadastro {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("MapaAtividadePU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Fracao fracao = manager.find(Fracao.class, 2L);
		
		System.out.println(fracao.getNomeFracao());
		
		// instanciamos e persistimos uma atividade
		Atividade atividade = new Atividade();
		atividade.setNomeAtividade("Desenvolvimento do sistema mapa");
		atividade.setDataInicio(new Date());
		atividade.setDataTermino(new Date());
		atividade.setStatus(StatusAtividade.EM_ANDAMENTO);
		atividade.setObservacao("Mapa de atividades do CCOMSEx");
		atividade.setFracao(fracao);

		manager.persist(atividade);

		trx.commit();
		manager.close();
	}

}
