package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import DAO.CategoriaDAO;
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

	public OfertaBean() {
		this.sistemaService = new SistemaService();
		this.categoriaService = new CategoriaService();
	}

	public List<SelectItem> selectCategoria() {
		// try {
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

	public void cadastrarOferta() {
		try {
			Oferta oferta = new Oferta();
			oferta.setTitulo(titulo);
			oferta.setDataOferta(getCurrentTimeStamp());
			oferta.setDescricao(descricao);
			oferta.setCategoria(categoria);
			oferta.setSistema(sistema);
			Usuario u = new Usuario();
			UsuarioService usuarioService = new UsuarioService();
			u = usuarioService.findById(1);
			oferta.setIdusuario(u);
			oferta.setStatus(status);
			valorHora = 22.22f;
			oferta.setValorHora(valorHora);
			oferta.setIdoferta(1);

		} catch (Exception e) {
			System.out.println("noffa");
			e.printStackTrace();
		} finally {
			ofertaService.save(oferta);
		}

	}

	public java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
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

}
