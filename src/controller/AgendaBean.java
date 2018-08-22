package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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
import util.Util;

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
	private Contratacao contratacaoSelecionada;
	private Agenda agendaAvaliar;

	/**
	 * Construtor instanciando os principais atributos
	 */
	public AgendaBean() {
		contratacaoService = new ContratacaoService();
		avaliacaoService = new AvaliacaoService();
		agendaService = new AgendaService();
		agenda = new Agenda();
		contratacao = new Contratacao();
		avaliacao = new Avaliacao();
		agendaAvaliar = new Agenda();
		oferta = (Oferta) Util.getSessionParameter("ofertaC"); /* Oferta na sessão */
		usuario = (Usuario) Util.getSessionParameter("usuarioL"); /* Usuário logado */
		setDataEhora(null);
	}

	/**
	 * Cadastro de Agenda e sua Chave Prim�ria(agendaPK)
	 *
	 */
	public void cadastrarAgenda() {
		agendaPK = novaChavePrimariaAgenda();
		agenda.setIdagenda(agendaPK); // Chave primária da agenda
		try {
			agendaService.save(agenda);
			limparForm();
			Util.mensagemInfo("Agenda salva com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Não foi possivel cadastrar a agenda!");
		}

	}

	/* Método de chave primaria da Classe Agenda */
	public AgendaPK novaChavePrimariaAgenda() {
		AgendaPK agendaPrimaria = new AgendaPK();
		if (dataEhora != null)
			agendaPrimaria.setDataEhora(dataEhora);
		else
			Util.mensagemErro("Favor inserir pelo menos uma Agenda");
		agendaPrimaria.setOferta(oferta); // Objeto oferta que está na sessão

		return agendaPrimaria;
	}

	public Agenda EncontrarAgenda() {
		Agenda agenda = new Agenda();
		agenda = agendaService.findById(agendaSelecionada.getIdagenda().getOferta().getIdoferta(),
				agendaSelecionada.getIdagenda().getDataEhora());
		agenda.setUsuario(usuario); // Setando o usuario logado
		return agenda;
	}

	public Contratacao novaContratacao() {
		Contratacao contratacao = new Contratacao();
		contratacao = new Contratacao();
		contratacao.setAgenda(agenda);
		contratacao.setDataContratacao(new Date());
		contratacao.setStatus('p'); // Pendente
		return contratacao;
	}

	public Contratacao encontrarContratacao() {
		Contratacao contratacao = new Contratacao();
		contratacao = contratacaoService.findById(agendaAvaliar.getIdagenda().getOferta().getIdoferta(),
				agendaAvaliar.getIdagenda().getDataEhora());
		return contratacao;
	}

	public Avaliacao novaAvaliacao() {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setIdcontratacao(contratacao);
		avaliacao.setAtendimento(atendimento);
		avaliacao.setServico(servico);
		avaliacao.setComentario(comentario);
		return avaliacao;
	}

	public void limparForm() {
		setDataEhora(null);
	}

	/**
	 * Atualiza��o de agenda com o id do usu�rio logado
	 *
	 */
	public String agendaUpdate() {
		agenda = EncontrarAgenda();
		try {
			agendaService.atualizar(agenda);
			cadastrarContratacao(); // Cadastrar na Tabela Contratação esta Agenda
			return "contratacaoSucesso";

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro interno");
			return "";
		}

	}

	/**
	 * Cadastrar Contrata��o ap�s a agenda ser atualizada com o id do usuario
	 *
	 */
	public void cadastrarContratacao() {
		try {
			contratacao = novaContratacao();
			contratacaoService.save(contratacao);
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Não foi possivel fazer a contratação");
		}

	}

	/**
	 * Listar agenda de data e hora pelo id da oferta selecionada na tela "Ofertas"
	 *
	 */
	public List<Agenda> findAgendaByOferta() {
		List<Agenda> listarAgenda = new ArrayList<Agenda>();
		listarAgenda = agendaService.listById(ofertaSelecionada.getIdoferta());
		return listarAgenda;
	}

	/**
	 * Listar todos as datas/horas contratadas pelo usuario logado
	 *
	 * @return
	 */
	public List<Agenda> listAgendaByIdUsuario() {
		List<Agenda> listAgendaByIdUsuario = new ArrayList<Agenda>();
		listAgendaByIdUsuario = agendaService.listAgendaByIdUsuario(usuario); // Id do usuario logado
		return listAgendaByIdUsuario;
	}

	/**
	 * Cadastrar a avalia��o do usu�rio
	 *
	 */
	public String avaliacao() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		sdf.format(agendaAvaliar.getIdagenda().getDataEhora());

		contratacao = encontrarContratacao();
		avaliacao = novaAvaliacao();
		try {
			avaliacaoService.save(avaliacao);
			Util.mensagemInfo("Avaliado com sucesso");
			return "avaliacaoSucesso"; // tela final do sistema na parte do usuário contratante

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Não foi possivel avaliar");
			return "";
		}

	}

	public String redirecionarAgenda() {
		Util.mensagemInfo("Concluído");
		return "ofertasUsuario";
	}

	/**
	 * Getters and Setters
	 *
	 */
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

	public Contratacao getContratacaoSelecionada() {
		return contratacaoSelecionada;
	}

	public void setContratacaoSelecionada(Contratacao contratacaoSelecionada) {
		this.contratacaoSelecionada = contratacaoSelecionada;
	}

	public Agenda getAgendaAvaliar() {
		return agendaAvaliar;
	}

	public void setAgendaAvaliar(Agenda agendaAvaliar) {
		this.agendaAvaliar = agendaAvaliar;
	}

}