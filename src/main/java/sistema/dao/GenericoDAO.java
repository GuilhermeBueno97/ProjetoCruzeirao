package sistema.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class GenericoDAO<T> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<T> classeEntidade;
	
	public GenericoDAO(){
		if(emf == null)
			emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
		
		em = emf.createEntityManager();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected T pesquisarUm(String namedQuery, Map parametros) {
		T resultado = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				popularParametrosQuery(query, parametros);
			}
			resultado = (T) query.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}
	
	protected void popularParametrosQuery(Query query,	Map<String, Object> parametros) {
		for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
	}
}
