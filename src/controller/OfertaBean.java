package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import DAO.SistemaDAO;
import model.Categoria;
import model.Municipios;
import model.Oferta;
import model.Sistema;
import model.Usuario;
import service.OfertaService;
import service.SistemaService;

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
	private String titulo;
	private String descricao;
	private float valorHora;
	private char status;
	private Categoria categoria;
	private List<SelectItem> sistemasSelect;
	private List<Categoria> categorias;
	private int sistema;

	public OfertaBean() {
		this.sistemaService = new SistemaService();
	}

	public List<SelectItem> selectSistema() {
		if (sistemasSelect == null) {
			sistemasSelect = new ArrayList<SelectItem>();
			List<Sistema> listasistemas = new ArrayList<Sistema>();
			listasistemas = sistemaService.listar();
			if (listasistemas != null && !listasistemas.isEmpty()) {
				SelectItem item;
				for (Sistema sistema : listasistemas) {
					item = new SelectItem(sistema, sistema.getNome());
					sistemasSelect.add(item);
				}
			}

		}
		return sistemasSelect;

	}

	public void cadastrarOferta() {
		Oferta oferta = new Oferta();
		oferta.setTitulo(titulo);
		oferta.setDataOferta(getCurrentTimeStamp());
		oferta.setDescricao(descricao);
		oferta.setIdcategoria(categoria);
		Sistema s = sistemaService.FindById(sistema);
		oferta.setSistema(s);
		oferta.setStatus(status);
		oferta.setValorHora(valorHora);
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public int getSistema() {
		return sistema;
	}

	public void setSistema(int sistema) {
		this.sistema = sistema;
	}

}
