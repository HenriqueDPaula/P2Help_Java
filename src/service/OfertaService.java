package service;

import java.io.Serializable;

import DAO.OfertaDAO;
import model.Oferta;

public class OfertaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -894570698311045270L;
	private OfertaDAO ofertaDAO;
	private Oferta oferta;

	public void save(Oferta oferta) {
		this.ofertaDAO.save(oferta);
	}

	public OfertaDAO getOfertaDAO() {
		return ofertaDAO;
	}

	public void setOfertaDAO(OfertaDAO ofertaDAO) {
		this.ofertaDAO = ofertaDAO;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
}
