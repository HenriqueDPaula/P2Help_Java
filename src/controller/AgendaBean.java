package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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
	private static final long serialVersionUID = 1414125843789937478L;
	private AgendaPK agendaPK;
	private Date data;
	private Date hora;
	private Usuario usuario;
	private Oferta oferta;
	private AgendaService agendaService;
	// private ContratacaoService contratacaoService;
	private Agenda agenda;

	public AgendaBean(){
//	contratacaoService = new ContratacaoService();
	agendaService = new AgendaService();
	agenda = new Agenda();
//	oferta = //ToDo rescue object from the session(na hora de cadastrar a oferta)
//	usuario = //ToDo rescue object Usuario from the session
	}

	public String cadastrar() {
		agendaPK.setHora(hora);
		agendaPK.setData(data);
//		agendaPK.setOferta(Oferta);
		agenda.setIdagenda(agendaPK);
		agenda.setUsuario(null);
		agendaService.save(agenda);

		return "ofertaData";
	}

	public Agenda inserirUsuario() {
		Agenda agenda = new Agenda();
		agenda = agendaService.findById(agendaPK);
		agenda.setUsuario(usuario);
		return agenda;

	}

	public String cadastrarContratacao() {
		Agenda agenda = inserirUsuario();
		agendaService.atualizar(agenda);

		// ToDo entender a regra negocial e cadastrar a agenda na tabela contratacao com
		// os demais atributos

		// contratacaoService.save(contratacao);
		// ToDo Faces Message de Contratação realizada com sucesso
		return "contratacaoSucesso";

	}

	public List<Agenda> listById() {
		List<Agenda> horarios = new ArrayList<Agenda>();
		// horarios = agendaService.listById();
		return horarios;
	}

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