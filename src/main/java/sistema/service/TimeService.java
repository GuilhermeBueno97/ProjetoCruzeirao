package sistema.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Time;

public class TimeService {
	private EntityManagerFactory emf;
	
	public TimeService(){
		emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
	}
	
	public void salvar(Time time){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(time);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Time time) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Time time2 = em.merge(time);
			em.remove(time2);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Time> getTimes(){
		List<Time> times;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Time u");
		times = q.getResultList();
		em.close();
		return times; 
	}
}
