package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import vo.Usuario;

public class UsuarioDAO {

	private Session session;
	private Transaction transation;

	public UsuarioDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void save(Usuario usuario) throws HibernateException {

		this.transation = this.session.beginTransaction();

		this.session.save(usuario);
		
		this.transation.commit();

	}
}
