package dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

	public boolean save(Usuario usuario) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		if (session.save(usuario) != null) {
			t.commit();
			return true;
		} else {
			return false;
		}

	}

	public Usuario login(String email, String senha) {

		Usuario usuario = null;

		// Processamento dos dados

		criteria = session.createCriteria(Usuario.class);

		criteria.add(Restrictions.eq("email", email));

		criteria.add(Restrictions.eq("senha", senha));

		usuario = (Usuario) criteria.uniqueResult();

		// Sa�da da informa��o

		return usuario;
	}

	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub

		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();

	}

	public Usuario findById(int idusuario) {

		Usuario usuario = null;

		criteria = session.createCriteria(Usuario.class);

		criteria.add(Restrictions.eq("idusuario", idusuario));

		usuario = (Usuario) criteria.uniqueResult();

		return usuario;
	}

	/**
	 * @return the criteria
	 */
	public Criteria getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

}
