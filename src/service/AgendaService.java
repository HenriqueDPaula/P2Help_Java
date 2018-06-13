package service;

import java.io.Serializable;
import java.util.List;

import dao.AgendaDAO;
import model.Agenda;
import model.AgendaPK;

public class AgendaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -312978313685550135L;
	private Agenda agenda;
	private AgendaPK agendaPK;
	private AgendaDAO agendaDAO;

	public AgendaService() {

		agendaDAO = new AgendaDAO();
		agendaPK = new AgendaPK();
		agenda = new Agenda();

	}

	// ToDo método para retornar os horários inseridos para uma oferta

//	public List<Agenda> listById(int idoferta) {
//		return this.agendaDAO.listById(idoferta);
//	}

	public void save(Agenda agenda) {
		this.agendaDAO.save(agenda);
	}

	public Agenda findById(AgendaPK agendaPK) {
		return this.agendaDAO.findById(agendaPK);
	}

	public void atualizar(Agenda agenda) {
		this.agendaDAO.atualizar(agenda);
	}

	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda
	 *            the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the agendaPK
	 */
	public AgendaPK getAgendaPK() {
		return agendaPK;
	}

	/**
	 * @param agendaPK
	 *            the agendaPK to set
	 */
	public void setAgendaPK(AgendaPK agendaPK) {
		this.agendaPK = agendaPK;
	}

	/**
	 * @return the agendaDAO
	 */
	public AgendaDAO getAgendaDAO() {
		return agendaDAO;
	}

	/**
	 * @param agendaDAO
	 *            the agendaDAO to set
	 */
	public void setAgendaDAO(AgendaDAO agendaDAO) {
		this.agendaDAO = agendaDAO;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ToDo Getters and Setters

}