package DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sun.media.jfxmedia.logging.Logger;

import model.Usuario;
import util.HibernateUtil;

public class UsuarioDAO implements IUsuarioDAO {

	private Session session;
	private Criteria criteria;
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

	public Usuario login() {
		Usuario usuario = null;

		// Processamento dos dados

		criteria = session.createCriteria(Usuario.class);

		criteria.add(Restrictions.eq("email", email));

		criteria.add(Restrictions.ne("senha", senha));

		usuario = (Usuario) criteria.uniqueResult();

		// Saída da informação

		return usuario;
	}

}
