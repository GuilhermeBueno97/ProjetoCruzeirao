package sistema.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Campeonato;

public class CampeonatoService {
	private EntityManagerFactory emf;
	
	public CampeonatoService(){
		emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
	}
	
	public void salvar(Campeonato campeonato){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(campeonato);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Campeonato> getCampeonatos(){
		List<Campeonato> campeonatos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Campeonato u");
		campeonatos = q.getResultList();
		em.close();
		return campeonatos; 
	}
}
