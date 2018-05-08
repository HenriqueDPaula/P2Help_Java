package DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Municipios;
import util.HibernateUtil;

public class MunicipiosDAO {

	private Session session;
	private Criteria criteria;

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

		Municipios municipio = null;
		
		criteria = session.createCriteria(Municipios.class);

		criteria.add(Restrictions.eq("idmunicipio", idmunicipio));

		municipio = (Municipios) criteria.uniqueResult();


		return municipio;
	}

}
