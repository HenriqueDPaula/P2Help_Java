package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Agenda;
import model.AgendaPK;
import model.Oferta;
import util.HibernateUtil;

public class AgendaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 871298166172188592L;
	private Session session;
	private Criteria criteria;
	private EntityManager em;

	public AgendaDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void save(Agenda agenda) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = (Transaction) session.beginTransaction();
		session.save(agenda);
		session.getTransaction().commit();
		session.close();
	}

	public void atualizar(Agenda agenda) {

		Transaction t = null;
		session = HibernateUtil.getSessionFactory().openSession();
		t = (Transaction) session.beginTransaction();
		session.update(agenda);
		session.getTransaction().commit();
		session.close();
	}

	public Agenda findById(AgendaPK agendaPK) {

		EntityManager em = null;
		Agenda agenda = null;

		agenda = em.find(Agenda.class, agendaPK);
		em.close();

		return agenda;

	}

	public List<Agenda> listById(int idoferta) {
		List<Agenda> listAgenda = null;

		session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Agenda where OFERTA = :idoferta";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idoferta", idoferta);
		listAgenda = query.list();

		return listAgenda;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}