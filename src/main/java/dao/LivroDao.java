package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Livro;
import iface.CRUD;
import util.JpaUtil;

public class LivroDao implements CRUD<Livro> {

	private static LivroDao INSTANCE = new LivroDao();
	// private EntityManager ent = Jpa.getEntityManager();

	public static LivroDao getInstance() {
		return INSTANCE;
	}

	public List<Livro> getList(String filter) {
		EntityManager ent = JpaUtil.getEntityManager();

		String sqlFilter = "";
		if (!filter.equals("")) {
			sqlFilter = " WHERE NOME LIKE '%" + filter + "%' OR DESCRICAO LIKE '%" + filter + "%'";
		}

		Query query = ent.createQuery(" from Livro  order by nome asc");

		List<Livro> livros = query.getResultList();

		ent.close();

		return livros;
	}

	public boolean create(Livro livro) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		boolean status = false;
		try {
			tx.begin();
			ent.persist(livro);
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

	public boolean update(Livro livro) {
		// Livro jogo1 = ent.find(Livro.class,id);

		EntityManager ent = JpaUtil.getEntityManager();
		boolean status = false;
		try {
			ent.getTransaction().begin();
			ent.merge(livro);
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

	public boolean delete(Livro livro) {
		EntityManager ent = JpaUtil.getEntityManager();
		boolean status = false;
		try {
			ent.getTransaction().begin();
			// ent.remove(ent.getReference(Livro.class, livro.getId()));
			ent.remove(livro);
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
