package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.sistema.model.entity.Fracao;

public class FracaoCadastro {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("MapaAtividadePU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		// instancia a fração pai
		Fracao fracaoPai = new Fracao();
		fracaoPai.setNomeFracao("Seção da Tecnologia da Informação");

		// instancia a fração filha
		Fracao fracaoFilha = new Fracao();
		fracaoFilha.setNomeFracao("Setor de Desenvolvimento");
		fracaoFilha.setFracaoPai(fracaoPai);

		// adiciona a fração
		fracaoPai.getFracaoFilha().add(fracaoFilha);

		manager.persist(fracaoPai);

		trx.commit();
		manager.close();
	}

}
