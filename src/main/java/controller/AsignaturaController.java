package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Docente;

public class AsignaturaController {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DocentesYAsignaturas");
	
	public static List<Asignatura> findAll(){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM asignatura", Asignatura.class);
		List<Asignatura> lista = (List<Asignatura>)q.getResultList();
		em.close();
		return lista;
	}

}
