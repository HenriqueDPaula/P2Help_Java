package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import model.Contratacao;
import org.hibernate.Query;
import util.HibernateUtil;

public class ContratacaoDAO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -9141579394237891883L;
	private Session session;
	private Criteria criteria;

	/**
	 * Salvar contratacao no banco
	 *
	 */
	public void save(Contratacao contratacao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.persist(contratacao);
		t.commit();

	}

	public Contratacao findById(int idoferta, Date dataEhora) {
		Contratacao contratacao = null;

		String hql = "from contratacao where idoferta =:idoferta, data_hora =: dataEhora";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idoferta", idoferta);
		query.setParameter("dataEhora", dataEhora);
		contratacao = (Contratacao) query.uniqueResult();

		return contratacao;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}