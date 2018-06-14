package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Agenda;
import model.AgendaPK;
import util.HibernateUtil;

public class AgendaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 871298166172188592L;
	private Session session;
	private Criteria criteria;

	//
	// public AgendaDAO() {
	// this.session = HibernateUtil.getSessionFactory().openSession();
	// }

	/**
	 * Persistir objeto agenda no banco
	 **/
	public void save(Agenda agenda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.persist(agenda);
		t.commit();

	}

	/**
	 * Atualizar objeto agenda
	 **/
	public void atualizar(Agenda agenda) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = (Transaction) session.beginTransaction();
			session.update(agenda);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Encontrat Agenda pelo seu id(agendaPK)
	 **/
	@SuppressWarnings("null")
	public Agenda findById(AgendaPK agendaPK) {

		EntityManager em = null;
		Agenda agenda = null;

		agenda = em.find(Agenda.class, agendaPK);
		em.close();

		return agenda;

	}

	/**
	 * Listar todas as agenda pelo id da oferta
	 **/
	@SuppressWarnings("unchecked")
	public List<Agenda> listById(int idoferta) {
		List<Agenda> listAgenda = null;

		session = HibernateUtil.getSessionFactory().openSession();

		String hql = "from Agenda where IDOFERTA = :idoferta";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("idoferta", idoferta);
		listAgenda = query.list();

		return listAgenda;
	}

	/**
	 * Deletar agenda
	 **/
	public void delete(Agenda agenda) {
		Transaction t = (Transaction) session.beginTransaction();
		session.delete(agenda);
		try {
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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