package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Editora;
import iface.CRUD;
import util.JpaUtil;

public class EditoraDao implements CRUD<Editora> {
	
	private static EditoraDao INSTANCE = new EditoraDao();
	
	public static EditoraDao getInstance() {
		return INSTANCE;
	}
	
	public List<Editora> getList(String filter){
		EntityManager ent = JpaUtil.getEntityManager();

		String sqlFilter = "";
		if (!filter.equals("")) {
			sqlFilter = " WHERE NOME LIKE '%" + filter + "%' OR DESCRICAO LIKE '%" + filter + "%'";
		}

		Query query = ent.createQuery(" from Editora  order by nome asc");

		List<Editora> editoras = query.getResultList();

		ent.close();

		return editoras;
	}	
	
	public List<Editora> getEditoras(){
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery(" from Editora  order by nome asc");

		List<Editora> editoras = query.getResultList();

		ent.close();

		return editoras;
	}
	
	public boolean create(Editora editora) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		boolean status = false;
		try {
			tx.begin();
			ent.persist(editora);
			tx.commit();
			status = true;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
			status = false;
		} finally {
			ent.close();
		}
		return status;

	}

	public boolean update(Editora editora) {
		// Livro jogo1 = ent.find(Livro.class,id);

		EntityManager ent = JpaUtil.getEntityManager();
		boolean status = false;
		try {
			ent.getTransaction().begin();
			ent.merge(editora);
			ent.getTransaction().commit();
			status = true;
		} catch (Exception e) {
			ent.getTransaction().rollback();
			status = false;
		} finally {
			ent.close();
		}
		return status;
	}

	public boolean delete(Editora editora) {
		EntityManager ent = JpaUtil.getEntityManager();
		boolean status = false;
		try {
			ent.getTransaction().begin();
			// ent.remove(ent.getReference(Livro.class, livro.getId()));
			ent.remove(editora);
			ent.getTransaction().commit();
			status = true;
		} catch (Exception e) {
			ent.getTransaction().rollback();
			status = false;
		} finally {
			ent.close();
		}
		return status;
	}


}
