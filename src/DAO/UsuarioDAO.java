package DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.media.jfxmedia.logging.Logger;

import model.Usuario;
import util.HibernateUtil;

public class UsuarioDAO implements IUsuarioDAO {

	private Session session;
	private String email;
	private String senha;
	private EntityManager em;

	public UsuarioDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void save(Usuario usuario) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
	}

	public Usuario validateLogin(String email, String senha) {
		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.email = :email and u.senha = :senha")
					.setParameter("name", email).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}

	}
}
