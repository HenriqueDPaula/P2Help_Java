package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Agenda;
import model.AgendaPK;
import model.Oferta;
import model.Usuario;
import service.AgendaService;

@SessionScoped
@Named("agendaBean")
public class AgendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8579903826986634497L;
	/**
	 * 
	 */
	private AgendaPK agendaPK;
	private Date data;
	private Date hora;
	private Usuario usuario;
	private Oferta oferta;
	private AgendaService agendaService;
	// private ContratacaoService contratacaoService;
	private Agenda agenda;

	public AgendaBean() {
		// contratacaoService = new ContratacaoService();
		agendaService = new AgendaService();
		agenda = new Agenda();
		agendaPK = new AgendaPK();
		oferta = (Oferta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ofertaC");
		usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioL");
	}

	public String cadastrar() throws ParseException {
		String dataString = "10/03/2018";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		data = sdf.parse(dataString);
		agendaPK.setData(data);
		String horaString = "21:09";
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		hora = sdf1.parse(horaString);

		agendaPK.setHora(hora);
		agendaPK.setOferta(oferta);
		agenda.setIdagenda(agendaPK);
		agenda.setUsuario(null);
		agendaService.save(agenda);

		return "pageUsuario";
	}

	/**
	 * @return the agendaPK
	 */
	public AgendaPK getAgendaPK() {
		return agendaPK;
	}

	/**
	 * @param agendaPK the agendaPK to set
	 */
	public void setAgendaPK(AgendaPK agendaPK) {
		this.agendaPK = agendaPK;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the hora
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the agendaService
	 */
	public AgendaService getAgendaService() {
		return agendaService;
	}

	/**
	 * @param agendaService the agendaService to set
	 */
	public void setAgendaService(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public Agenda inserirUsuario() {
//		Agenda agenda = new Agenda();
//		agenda = agendaService.findById(agendaPK);
//		agenda.setUsuario(usuario);
//		return agenda;
//
//	}
//
//	public String cadastrarContratacao() {
//		Agenda agenda = inserirUsuario();
//		agendaService.atualizar(agenda);
//
//		// ToDo entender a regra negocial e cadastrar a agenda na tabela contratacao com
//		// os demais atributos
//
//		// contratacaoService.save(contratacao);
//		// ToDo Faces Message de Contratação realizada com sucesso
//		return "contratacaoSucesso";
//
//	}
//
//	public List<Agenda> listById() {
//		List<Agenda> horarios = new ArrayList<Agenda>();
//		// horarios = agendaService.listById();
//		return horarios;
//	}

	// ToDo Getters and Setters
}

/**
 * para o front
 * 
 * <p:outputLabel for="AgendaDATA" value="Data da oferta:" />
 * <p:calendar id="AgendaDATA" value="#{agendaBean.data}" />
 * 
 * <p:outputLabel for="AgendaHORA" value="Hora:" />
 * <p:calendar id="AgendaHORA" value="#{agendaBean.hora}" pattern="HH:mm"
 * timeOnly="true" />
 **/