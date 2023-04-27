package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;


public class DocenteController {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DocentesYAsignaturas");
	
	public static List<Docente> findByDesc(String str){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM docente where nombreCompleto like '%" + str + "%'", Docente.class);
		List<Docente> lista = (List<Docente>)q.getResultList();
		em.close();
		return lista;
	}

}
