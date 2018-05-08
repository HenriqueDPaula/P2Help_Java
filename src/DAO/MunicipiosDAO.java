package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Municipios;
import util.HibernateUtil;

public class MunicipiosDAO {

	private Session session;

	public MunicipiosDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void save(Municipios municipio) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(municipio);
		t.commit();
	}

	public Municipios findById(int idmunicipio) {
		Municipios municipio;
		this.session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		return (Municipios) session.createCriteria(Municipios.class).add(Restrictions.eq("idmunicipio", idmunicipio))
				.uniqueResult();
	}

}
