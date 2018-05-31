package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

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
	private List<SelectItem> sistemaSelect;
	private List<SelectItem> selectMunicipio;
	private Usuario usuario;
	private OfertaService ofertaService;
	private SistemaService sistemaService;
	private String titulo;
	private String descricao;
	private float valorHora;
	private char status;
	private Sistema idsistema;
	private Categoria idcategoria;

	public OfertaBean() {

	}

	public List<SelectItem> selectSistema() {
		if (sistemaSelect == null) {
			sistemaSelect = new ArrayList<SelectItem>();
			List<Sistema> listaSistema = new ArrayList<Sistema>();
			listaSistema = sistemaService.listar();
			if (listaSistema != null && !listaSistema.isEmpty()) {
				SelectItem item;
				for (Sistema sistema : listaSistema) {
					item = new SelectItem(sistema, sistema.getNome(), sistema.getFabricante());
					sistemaSelect.add(item);
				}
			}

		}
		return sistemaSelect;
	}

	public void cadastrarOferta() {
		Oferta oferta = new Oferta();
		oferta.setTitulo(titulo);
		oferta.setDataOferta(getCurrentTimeStamp());
		oferta.setDescricao(descricao);
		oferta.setIdcategoria(idcategoria);
		oferta.setIdsistema(idsistema);
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

	public List<SelectItem> getSelectMunicipio() {
		return selectMunicipio;
	}

	public void setSelectMunicipio(List<SelectItem> selectMunicipio) {
		this.selectMunicipio = selectMunicipio;
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

	public List<SelectItem> getSistemaSelect() {
		return sistemaSelect;
	}

	public void setSistemaSelect(List<SelectItem> sistemaSelect) {
		this.sistemaSelect = sistemaSelect;
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

	public Sistema getIdsistema() {
		return idsistema;
	}

	public void setIdsistema(Sistema idsistema) {
		this.idsistema = idsistema;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

}
