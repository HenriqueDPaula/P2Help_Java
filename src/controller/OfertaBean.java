package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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
import util.Util;

@SessionScoped
@Named("ofertaBean")
public class OfertaBean implements Serializable {

	/**
	 * Atributos
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
	private String sistemaNome;
	private String sistemaFabricante;

	/**
	 * Construtor, instanciado as devidas Services e pegando o usuario logado na
	 * sess�o
	 */
	public OfertaBean() {
		this.oferta = new Oferta();
		this.sistemaService = new SistemaService();
		this.categoriaService = new CategoriaService();
		this.ofertaService = new OfertaService();
		this.usuarioService = new UsuarioService();
		selectSistema();
		usuario = (Usuario) Util.getSessionParameter("usuarioL"); // usuario

	}

	/**
	 * M�todo para SelectOne do primefaces de Categoria, com SelectItem
	 *
	 * @return
	 */
	public List<SelectItem> selectCategoria() {
		categoriasSelect = new ArrayList<SelectItem>();
		List<Categoria> listacategoria = new ArrayList<Categoria>();
		listacategoria = categoriaService.listar();
		if (listacategoria != null && !listacategoria.isEmpty()) {
			for (Categoria categoria : listacategoria) {
				SelectItem item1 = new SelectItem(categoria, categoria.getDescricao());
				categoriasSelect.add(item1);
			}
		}
		return categoriasSelect;
	}

	/**
	 * M�todo para SelectOne do primefaces de Sistema, com SelectItem
	 *
	 * @return
	 */
	public List<SelectItem> selectSistema() {
		sistemasSelect = new ArrayList<>();
		List<Sistema> listasistemas = new ArrayList<>();
		listasistemas = sistemaService.listar();
		if (listasistemas != null && !listasistemas.isEmpty()) {
			for (Sistema sistema : listasistemas) {
				SelectItem item = new SelectItem(sistema, sistema.getNome());
				sistemasSelect.add(item);
			}
		}
		return sistemasSelect;
	}

	public Oferta novaOferta() {
		Oferta oferta = new Oferta();
		oferta.setTitulo(titulo);
		oferta.setDataOferta(new Date()); // Data e hora do sistema
		oferta.setDescricao(descricao);
		oferta.setCategoria(categoria);
		oferta.setSistema(sistema);
		oferta.setUsuario(usuario);
		oferta.setStatus('s'); // Ativo
		oferta.setValorHora(valorHora);
		return oferta;
	}

	/**
	 * Cadastrar Oferta o
	 * 
	 * @return
	 */
	public String cadastrar() {
		oferta = novaOferta();
		try {
			ofertaService.save(oferta);
			Util.setSessionParameter("ofertaC", oferta); // oferta // sessão
			Util.mensagemInfo("Oferta cadastrada com sucesso!");
			return "agenda";
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Não foi possivel cadastrar a oferta");
			return "cadastrarOferta";
		}

	}

	/**
	 * Localizar oferta pelo id e redirecionar para a pagina para editar
	 *
	 * @return Ofertas
	 */
	public Oferta encontrarOfertaPeloID() {
		this.oferta = ofertaService.findById(this.oferta.getIdoferta()); // Encontrando oferta pelo id para atualizar
		return oferta;
	}

	/**
	 * Atualizando oferta
	 *
	 * @return
	 */
	public String atualizar() {
		oferta.setDataOferta(new Date()); // Data e hora do sistema
		try {
			ofertaService.atualizar(oferta);
			Util.mensagemInfo("Oferta atualizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Erro, não foi possivel atualizar a oferta");
		}

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

	/**
	 * Listar ofertas pelo id do usuario
	 * 
	 * @return
	 */
	public List<Oferta> listById() {
		listOferta = ofertaService.listById(usuario.getIdusuario());
		if (listOferta != null || !listOferta.isEmpty()) {
			return listOferta;
		} else {
			Util.mensagemInfo("Não há ofertas cadastradas");
			return null;
		}
	}

	/**
	 * Apagar Oferta
	 */
	public String deleteOferta() {
		this.oferta = encontrarOfertaPeloID();
		try {
			deleteConfirm(); // Método chamando a service de oferta
			Util.mensagemInfo("Oferta excluída!");
		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemInfo("Contrato atrelado a esta oferta!");
		}
		return "pageUsuario";

	}

	/**
	 * Deletar oferta
	 */
	public void deleteConfirm() {
		try {
			ofertaService.delete(this.oferta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sistema novoSistema() {
		Sistema sistema = new Sistema();
		sistema.setFabricante(sistemaNome);
		sistema.setNome(sistemaFabricante);
		return sistema;
	}

	public void cadastrarSistema() {
		try {
			sistema = novoSistema();
			sistemaService.save(sistema);
			Util.mensagemInfo("Sistema cadastrado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
			Util.mensagemErro("Não foi possivel cadastrar o sistema");
		}

	}

	public String detalheSistema() {
		return oferta.getSistema().getNome();
	}

	public String detalheCategoria() {
		return oferta.getCategoria().getDescricao();
	}

	public String redirecionaOfertas() {
		return "Ofertas.jsf";
	}

	public String redirecionarContratadas() {
		return "ofertasContratadas.jsf";
	}

	public String redirecionaCadastroOferta() {
		return "cadastrarOferta.jsf";
	}

	public String redirecionaOfertasUsuario() {
		return "ofertasUsuario.jsf";
	}

	// GETTERS AND SETTERS
	public String redirecionarSistema() {
		return "cadastrarSistema.jsf";
	}

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

	/**
	 * @return the listOferta
	 */
	public List<Oferta> getListOferta() {
		return listOferta;
	}

	/**
	 * @param listOferta
	 *            the listOferta to set
	 */
	public void setListOferta(List<Oferta> listOferta) {
		this.listOferta = listOferta;
	}

	/**
	 * @return the sistemaNome
	 */
	public String getSistemaNome() {
		return sistemaNome;
	}

	/**
	 * @param sistemaNome
	 *            the sistemaNome to set
	 */
	public void setSistemaNome(String sistemaNome) {
		this.sistemaNome = sistemaNome;
	}

	/**
	 * @return the sistemaFabricante
	 */
	public String getSistemaFabricante() {
		return sistemaFabricante;
	}

	/**
	 * @param sistemaFabricante
	 *            the sistemaFabricante to set
	 */
	public void setSistemaFabricante(String sistemaFabricante) {
		this.sistemaFabricante = sistemaFabricante;
	}

}