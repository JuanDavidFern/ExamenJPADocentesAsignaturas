package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

public class AsignaturaPorDocenteController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("DocentesYAsignaturas");

	public static List<Asignaturaspordocente> findByDocente(Docente d) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = " + d.getId() + ";",
				Asignaturaspordocente.class);
		List<Asignaturaspordocente> lista = (List<Asignaturaspordocente>) q.getResultList();
		em.close();
		return lista;
	}

	public static void delete(List<Asignaturaspordocente> o) {
		System.out.println(o.toString());
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		for (Asignaturaspordocente asignaturaspordocente : o) {
			em.remove(em.merge(asignaturaspordocente));
		}
		em.getTransaction().commit();
		em.close();
	}

	public static void insert(Asignaturaspordocente o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

}
