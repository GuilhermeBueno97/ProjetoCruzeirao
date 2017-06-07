package sistema.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.modelos.Usuario;

public class UsuarioService {
	private EntityManagerFactory emf;

	public UsuarioService() {
		emf = Persistence.createEntityManagerFactory("CruzeiraoJavamen");
	}

	public void salvar(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public Usuario getUsuarioAtual(String name) {

		List<Usuario> users = this.getUsuarios();

		for (Usuario u : users) {
			if (u.getUsername() == name)
				return u;
		}

		return null;
	}

	public Usuario salvarEditado(Usuario usuario) {

		Usuario user = null;
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		user = em.merge(usuario);
		em.getTransaction().commit();
		em.close();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		List<Usuario> users;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u");
		users = q.getResultList();
		em.close();
		return users;
	}
}
