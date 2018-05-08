package DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import model.Sistema;
import util.HibernateUtil;

public class SistemaDAO implements ISistemaDAO{

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

	@SuppressWarnings("unchecked")
	public List<Sistema> listar() {

		List<Sistema> sistemas = null;

		// Processamento dos dados

		criteria = session.createCriteria(Sistema.class);

		criteria.addOrder(Order.asc("nome"));

		sistemas = criteria.list();

		return sistemas;
	}

}