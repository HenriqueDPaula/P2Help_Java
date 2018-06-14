package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Agenda;
import model.AgendaPK;
import model.Avaliacao;
import model.Contratacao;
import model.Oferta;
import model.Usuario;
import service.AgendaService;
import service.AvaliacaoService;
import service.ContratacaoService;

@SessionScoped
@Named("agendaBean")
public class AgendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8579903826986634497L;

	/**
	 * Atributos
	 */
	private AgendaPK agendaPK;
	private Date dataEhora;
	private Usuario usuario;
	private Oferta oferta;
	private AgendaService agendaService;
	private ContratacaoService contratacaoService;
	private AvaliacaoService avaliacaoService;
	private Agenda agenda;
	private Avaliacao avaliacao;
	private Integer servico;
	private Integer atendimento;
	private String comentario;
	private Contratacao contratacao;
	private Oferta ofertaSelecionada;
	private List<Agenda> listarAgenda;
	private Agenda agendaSelecionada;

	/**
	 * Construtor instanciando os principais atributos
	 */
	public AgendaBean() {
		contratacaoService = new ContratacaoService();
		avaliacaoService = new AvaliacaoService();
		agendaService = new AgendaService();
		agenda = new Agenda();
		oferta = (Oferta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ofertaC"); // Oferta
																													// que
																													// está
																													// na
																													// sessão
		usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioL"); // Usuario
																													// logado

	}

	/**
	 * Cadastro de Agenda e sua Chave Primária(agendaPK)
	 * 
	 * @throws ParseException
	 **/
	public void cadastrarAgenda() {

		agendaPK = new AgendaPK();
		agendaPK.setDataEhora(dataEhora);
		agendaPK.setOferta(oferta);
		agenda.setIdagenda(agendaPK);
		agendaService.save(agenda);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda", " Cadastrada com sucesso!"));
		setDataEhora(null);

	}

	/**
	 * Atualização de agenda com o id do usuário logado
	 **/
	public Agenda agendaUpdate() {
		Agenda agenda = new Agenda();
		agenda = agendaService.findById(agendaPK); // Encontrando a agenda pela chave primária(agendaPK)
		agenda.setUsuario(usuario);
		agendaService.atualizar(agenda);
		return agenda;
	}

	/**
	 * Cadastrar Contratação após a agenda ser atualizada com o id do usuario
	 **/
	public void cadastrarContratacao() {
		contratacao.setAgenda(agendaSelecionada);
		java.util.Date date = new java.util.Date(); // Instanciando um objeto do tipo Date da classe java.util
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		contratacao.setDataContratacao(sqlTimestamp);
		contratacao.setStatus('p');
		contratacaoService.save(contratacao);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta", " Contratada!"));

	}

	/**
	 * Listar agenda de data e hora pelo id da oferta selecionada na tela "Ofertas"
	 **/
	public List<Agenda> findAgendaByOferta() {
		List<Agenda> listarAgenda = null;
		listarAgenda = agendaService.listById(ofertaSelecionada.getIdoferta());
		return listarAgenda;
	}

	/**
	 * Cadastrar a avaliação do usuário
	 **/
	public String avaliacao() {

		avaliacao.setIdcontratacao(contratacao);
		avaliacao.setAtendimento(atendimento);
		avaliacao.setServico(servico);
		avaliacaoService.save(avaliacao);

		return ""; // ToDo
	}

	/**
	 * Getters and Setters
	 **/

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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
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
	 * @param oferta
	 *            the oferta to set
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
	 * @param agendaService
	 *            the agendaService to set
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
	 * @param agenda
	 *            the agenda to set
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

	/**
	 * @return the dataEhora
	 */
	public Date getDataEhora() {
		return dataEhora;
	}

	/**
	 * @param dataEhora
	 *            the dataEhora to set
	 */
	public void setDataEhora(Date dataEhora) {
		this.dataEhora = dataEhora;
	}

	/**
	 * @return the contratacaoService
	 */
	public ContratacaoService getContratacaoService() {
		return contratacaoService;
	}

	/**
	 * @param contratacaoService
	 *            the contratacaoService to set
	 */
	public void setContratacaoService(ContratacaoService contratacaoService) {
		this.contratacaoService = contratacaoService;
	}

	/**
	 * @return the avaliacaoService
	 */
	public AvaliacaoService getAvaliacaoService() {
		return avaliacaoService;
	}

	/**
	 * @param avaliacaoService
	 *            the avaliacaoService to set
	 */
	public void setAvaliacaoService(AvaliacaoService avaliacaoService) {
		this.avaliacaoService = avaliacaoService;
	}

	/**
	 * @return the avaliacao
	 */
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	/**
	 * @param avaliacao
	 *            the avaliacao to set
	 */
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * @return the servico
	 */
	public Integer getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            the servico to set
	 */
	public void setServico(Integer servico) {
		this.servico = servico;
	}

	/**
	 * @return the atendimento
	 */
	public Integer getAtendimento() {
		return atendimento;
	}

	/**
	 * @param atendimento
	 *            the atendimento to set
	 */
	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the contratacao
	 */
	public Contratacao getContratacao() {
		return contratacao;
	}

	/**
	 * @param contratacao
	 *            the contratacao to set
	 */
	public void setContratacao(Contratacao contratacao) {
		this.contratacao = contratacao;
	}

	/**
	 * @return the ofertaSelecionada
	 */
	public Oferta getOfertaSelecionada() {
		return ofertaSelecionada;
	}

	/**
	 * @param ofertaSelecionada
	 *            the ofertaSelecionada to set
	 */
	public void setOfertaSelecionada(Oferta ofertaSelecionada) {
		this.ofertaSelecionada = ofertaSelecionada;
	}

	/**
	 * @return the listarAgenda
	 */
	public List<Agenda> getListarAgenda() {
		return listarAgenda;
	}

	/**
	 * @param listarAgenda
	 *            the listarAgenda to set
	 */
	public void setListarAgenda(List<Agenda> listarAgenda) {
		this.listarAgenda = listarAgenda;
	}

	/**
	 * @return the agendaSelecionada
	 */
	public Agenda getAgendaSelecionada() {
		return agendaSelecionada;
	}

	/**
	 * @param agendaSelecionada
	 *            the agendaSelecionada to set
	 */
	public void setAgendaSelecionada(Agenda agendaSelecionada) {
		this.agendaSelecionada = agendaSelecionada;
	}

	// public Agenda inserirUsuario() {
	// Agenda agenda = new Agenda();
	// agenda = agendaService.findById(agendaPK);
	// agenda.setUsuario(usuario);
	// return agenda;
	//
	// }
	//
	// public String cadastrarContratacao() {
	// Agenda agenda = inserirUsuario();
	// agendaService.atualizar(agenda);
	//
	// // ToDo entender a regra negocial e cadastrar a agenda na tabela contratacao
	// com
	// // os demais atributos
	//
	// // contratacaoService.save(contratacao);
	// // ToDo Faces Message de Contratação realizada com sucesso
	// return "contratacaoSucesso";
	//
	// }
	//
	// public List<Agenda> listById() {
	// List<Agenda> horarios = new ArrayList<Agenda>();
	// // horarios = agendaService.listById();
	// return horarios;
	// }

	// ToDo Getters and Setters
}