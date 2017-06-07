package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Convite;

public class ConviteService {
	private EntityManagerFactory emf;
	
	public ConviteService(){
		emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
	}
	
	public void salvar(Convite convite){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(convite);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Convite convite) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Convite conv = em.merge(convite);
			em.remove(conv);
		em.getTransaction().commit();
		em.close();
	}
	
	public Convite salvarEditado(Convite convite) {

		Convite c = null;
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			c = em.merge(convite);
		em.getTransaction().commit();
		em.close();
		
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Convite> getConvites(){
		List<Convite> convites;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Convite u");
		convites = q.getResultList();
		em.close();
		return convites; 
	}
}
