package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Oferta;
import util.HibernateUtil;

public class OfertaDAO implements IOfertaDAO {

	private Criteria criteria;
	private Session session;

	@Override
	public void save(Oferta oferta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.persist(oferta);
		t.commit();

	}

	@Override
	public Oferta findById(int idoferta) {

		Oferta oferta = null;

		criteria = session.createCriteria(Oferta.class);

		criteria.add(Restrictions.eq("idoferta", idoferta));

		oferta = (Oferta) criteria.uniqueResult();

		return oferta;
	}

	@Override
	public List<Oferta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Oferta oferta) {
		this.session.delete(oferta);

	}

}
