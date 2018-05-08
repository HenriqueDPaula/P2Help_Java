package DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import model.Sistema;
import util.HibernateUtil;

public class SistemaDAO {

	private Session session;
	private Criteria criteria;

	public SistemaDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void save(Sistema sistema) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(sistema);
		t.commit();
	}

	public Sistema findById(int idsistema) {

		Sistema sistema = null;
		
		criteria = session.createCriteria(Sistema.class);

		criteria.add(Restrictions.eq("idsistema", idsistema));

		sistema = (Sistema) criteria.uniqueResult();


		return sistema;
	}

}