package sistema.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Inscricao;

public class InscricaoService {
	private EntityManagerFactory emf;
	
	public InscricaoService(){
		emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
	}
	
	public void salvar(Inscricao inscricao){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(inscricao);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Inscricao insc) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Inscricao insc2 = em.merge(insc);
			em.remove(insc2);
		em.getTransaction().commit();
		em.close();
	}
	
	public Inscricao salvarEditado(Inscricao i) {

		Inscricao insc = null;
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			insc = em.merge(i);
		em.getTransaction().commit();
		em.close();
		
		return insc;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao> getInscricoes(){
		List<Inscricao> inscricoes;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Inscricao u");
		inscricoes = q.getResultList();
		em.close();
		return inscricoes; 
	}
}
