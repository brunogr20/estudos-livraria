package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Livro;
import entities.Usuario;
import util.JpaUtil;
import util.HashUtil;

public class UsuarioDao {

	private static UsuarioDao INSTANCE = new UsuarioDao();

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}

	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public boolean create(Usuario usuario) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		boolean status = false;

		// hash senha
		usuario.setSenha(HashUtil.getHash(usuario.getSenha()));

		try {
			tx.begin();
			ent.persist(usuario);
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

	public boolean login(String cpf, String senha) {
		EntityManager ent = JpaUtil.getEntityManager();
		boolean status = false;
		senha = HashUtil.getHash(senha);
		try {
			Query query = ent.createQuery(" from Usuario where CPF = :CPF AND SENHA = :SENHA  ");
			
			query.setParameter("CPF", cpf);
			query.setParameter("SENHA", senha);
			
			if (query.getResultList().size() > 0) {
				status = true;
			}

		} catch (Exception e) {
			status = false;
			System.out.println("Erro: "+e.getMessage());
		} finally {
			ent.close();
		}

		return status;
	}

	public boolean sinbleField(String type, String field) {
		String sql = "";
		boolean status = true;
		if (type == "CPF") {
			sql = " from Usuario where CPF = " + field;
		}
		if (!sql.equals("")) {
			EntityManager ent = JpaUtil.getEntityManager();
			try {
				Query query = ent.createQuery(sql);

				if (query.getResultList().size() > 0) {
					status = false;
				}
				;

			} catch (Exception e) {
				status = false;
				System.out.println(e.getMessage());
				} finally {
				ent.close();
			}
		}

		return status;
	}

}
