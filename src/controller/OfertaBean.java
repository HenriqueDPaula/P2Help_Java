package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import dao.CategoriaDAO;
import model.Categoria;
import model.Municipios;
import model.Oferta;
import model.Sistema;
import model.Usuario;
import service.CategoriaService;
import service.OfertaService;
import service.SistemaService;
import service.UsuarioService;

@ManagedBean
@RequestScoped
@Named("ofertaBean")
public class OfertaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5998663528528731657L;
	private Oferta oferta;
	private Municipios municipio;
	private Usuario usuario;
	private OfertaService ofertaService;
	private SistemaService sistemaService;
	private CategoriaService categoriaService;
	private String titulo;
	private String descricao;
	private float valorHora;
	private char status;
	private Categoria categoria;
	private List<SelectItem> sistemasSelect;
	private List<SelectItem> categoriasSelect;
	private List<Categoria> categorias;
	private Sistema sistema;
	private CategoriaDAO categoriaDAO;
	private boolean radio;
	private UsuarioService usuarioService;
	private List<Oferta> listOfertas;
	private List<Oferta> listOferta;
	private Boolean flagModal;
	private Oferta ofertaSelecionada;

	/**
	 * Construtor, instanciado as devidas Services e pegando o usuario logado na
	 * sessão
	 */
	public OfertaBean() {
		this.sistemaService = new SistemaService();
		this.categoriaService = new CategoriaService();
		this.ofertaService = new OfertaService();
		this.usuarioService = new UsuarioService();
		usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioL"); // usuario
																													// logado
		flagModal = false;
	}

	/**
	 * Método para SelectOne do primefaces de Categoria, com SelectItem
	 * 
	 * @return
	 */
	public List<SelectItem> selectCategoria() {
		if (categoriasSelect == null) {
			categoriasSelect = new ArrayList<SelectItem>();
			List<Categoria> listacategoria = new ArrayList<Categoria>();
			listacategoria = categoriaService.listar();
			if (listacategoria != null && !listacategoria.isEmpty()) {
				for (Categoria categoria : listacategoria) {
					SelectItem item1 = new SelectItem(categoria, categoria.getDescricao());
					categoriasSelect.add(item1);
				}
			}
		}
		return categoriasSelect;
	}

	/**
	 * Método para SelectOne do primefaces de Sistema, com SelectItem
	 * 
	 * @return
	 */
	public List<SelectItem> selectSistema() {
		if (sistemasSelect == null) {
			sistemasSelect = new ArrayList<SelectItem>();
			List<Sistema> listasistemas = new ArrayList<Sistema>();
			listasistemas = sistemaService.listar();
			if (listasistemas != null && !listasistemas.isEmpty()) {
				for (Sistema sistema : listasistemas) {
					SelectItem item = new SelectItem(sistema, sistema.getNome());
					sistemasSelect.add(item);
				}
			}

		}
		return sistemasSelect;

	}

	/**
	 * Cadastrar Oferta
	 * 
	 * @return
	 */
	public String cadastrar() {

		oferta = new Oferta();
		oferta.setTitulo(titulo);
		java.util.Date date = new java.util.Date(); // Instanciando um objeto do tipo Date da classe java.util
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		oferta.setDataOferta(sqlTimestamp);
		oferta.setDescricao(descricao);
		oferta.setCategoria(categoria);
		oferta.setSistema(sistema);
		oferta.setUsuario(usuario);

		if (radio == true) { // Setando o status da oferta com RadioButton no front
			status = 's';
			oferta.setStatus(status);
		} else {
			status = 'n';
			oferta.setStatus(status);
		}

		oferta.setValorHora(valorHora);

		ofertaService.save(oferta);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta cadastrada com sucesso!", " "));
		return "pageOferta";

	}

	/**
	 * Localizar oferta pelo id e redirecionar para a pagina para editar
	 * 
	 * @return Ofertas
	 */
	public String atualizar() {
		oferta = ofertaService.findById(oferta.getIdoferta());
		return "atualizarOferta";
	}

	/**
	 * Atualizando oferta
	 * 
	 * @return
	 */
	public String atualizarConfirm() {

		ofertaService.atualizar(this.oferta);

		return "pageOferta";
	}

	/**
	 * Listagem de todas as ofertas
	 * 
	 * @return lista de ofertas
	 */
	public List<Oferta> listarOfertas() {

		listOfertas = ofertaService.listarOfertas();

		return listOfertas;
	}

	public List<Oferta> listById() {
		listOferta = ofertaService.listById(usuario.getIdusuario());
		if (listOferta != null) {
			return listOferta;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "nenhuma", " Oferta cadastrada"));
			return null;
		}
	}

	/**
	 * Apagar Oferta
	 */
	public String deleteOferta() {
		this.oferta = ofertaService.findById(this.oferta.getIdoferta());
		deleteConfirm();
		this.refresh();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta Excluida", " "));
		return "ofertasUsuario";

	}

	public void deleteConfirm() {
		ofertaService.delete(this.oferta);
	}

	/**
	 * Método para retornar nome do sistema
	 * 
	 * @return Nome sistema
	 */
	public String detalheSistema() {

		return oferta.getSistema().getNome();
	}

	/**
	 * Método para retornar nome da categoria
	 * 
	 * @return Descricao Categoria
	 */
	public String detalheCategoria() {

		return oferta.getCategoria().getDescricao();
	}

	/*
	 * Redirecionamento de página
	 */
	public String redirecionaOfertas() {
		return "Ofertas";
	}

	/*
	 * Redirecionamento de página
	 */
	public String redirecionaCadastroOferta() {
		return "cadastrarOferta";
	}

	public String redirecionaOfertasUsuario() {
		return "ofertasUsuario";
	}

	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public OfertaService getOfertaService() {
		return ofertaService;
	}

	public void setOfertaService(OfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SistemaService getSistemaService() {
		return sistemaService;
	}

	public void setSistemaService(SistemaService sistemaService) {
		this.sistemaService = sistemaService;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<SelectItem> getSistemasSelect() {
		return sistemasSelect;
	}

	public void setSistemasSelect(List<SelectItem> sistemasSelect) {
		this.sistemasSelect = sistemasSelect;
	}

	public List<Sistema> getSistemas() {

		return sistemaService.listar();
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public List<SelectItem> getCategoriasSelect() {
		return categoriasSelect;
	}

	public void setCategoriasSelect(List<SelectItem> categoriasSelect) {
		this.categoriasSelect = categoriasSelect;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	/**
	 * @return the radio
	 */
	public boolean isRadio() {
		return radio;
	}

	/**
	 * @param radio
	 *            the radio to set
	 */
	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @return the listOfertas
	 */
	public List<Oferta> getListOfertas() {
		return listOfertas;
	}

	/**
	 * @param listOfertas
	 *            the listOfertas to set
	 */
	public void setListOfertas(List<Oferta> listOfertas) {
		this.listOfertas = listOfertas;
	}
	// public void onRowSelect(SelectEvent event) {
	// FacesMessage msg = new FacesMessage("Car Selected", event.;
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	//
	// public void onRowUnselect(UnselectEvent event) {
	// FacesMessage msg = new FacesMessage("Car Unselected", ((Car)
	// event.getObject()).getId());
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }

	/**
	 * @return the ofertaSelecionada
	 */

	/**
	 * @return the flagModal
	 */
	public Boolean getFlagModal() {
		return flagModal;
	}

	/**
	 * @param flagModal
	 *            the flagModal to set
	 */
	public void setFlagModal(Boolean flagModal) {
		this.flagModal = flagModal;
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

}