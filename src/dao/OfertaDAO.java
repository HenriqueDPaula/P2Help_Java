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

	/**
	 * Cadastrar Oferta no Banco
	 */
	@Override
	public void save(Oferta oferta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.persist(oferta);
		t.commit();

	}

	/**
	 * Encontrar oferta pelo seu id
	 */
	@Override
	public Oferta findById(int idoferta) {

		Oferta oferta = null;

		criteria = session.createCriteria(Oferta.class);

		criteria.add(Restrictions.eq("idoferta", idoferta));

		oferta = (Oferta) criteria.uniqueResult();

		return oferta;
	}

	/**
	 * Atualizar oferta
	 * 
	 * @param oferta
	 */
	public void atualizar(Oferta oferta) {

		Transaction t = session.beginTransaction();
		session.update(oferta);
		t.commit();

	}

	/**
	 * Listar todas as ofertas
	 */
	@SuppressWarnings("unchecked")
	public List<Oferta> listar() {

		session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Oferta.class);

		List<Oferta> listaOfertas = criteria.list();

		return listaOfertas;
	}

	/**
	 * Apagar Oferta
	 */
	@Override
	public boolean delete(Oferta oferta) {
		boolean flag = false;
		session.delete(oferta);
		flag = true;
		return flag;
	}

}
