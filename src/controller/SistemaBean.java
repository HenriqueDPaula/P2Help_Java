package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import model.Sistema;
import service.SistemaService;

@ManagedBean
@RequestScoped
@Named("sistemaBean")
public class SistemaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1586597289480682468L;
	private String nome1;
	private String fabricante1;
	private SistemaService sistemaService;
	private Sistema sistema;

	public SistemaBean() {
		this.sistemaService = new SistemaService();
	}

	/*
	 * Cadstro de Sistema sem verificaçao
	 */
	public String CadastrarSistema() {
		sistema = new Sistema();
		sistema.setFabricante("maria");
		sistema.setNome("joseph");
		sistemaService.save(sistema);
		return "cadastrarOferta";
	}

	// public List<Sistema> selectOne() {
	// MunicipioService muniS = new MunicipioService();
	// List<Municipios> muniL = new ArrayList();
	// muniL = muniS.listar();
	// for (Municipios municipios : muniL) {
	// muniL.add(new Municipios());
	// }
	//
	// return muniL;
	// }

	public SistemaService getSistemaService() {
		return sistemaService;
	}

	public void setSistemaService(SistemaService sistemaService) {
		this.sistemaService = sistemaService;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	/**
	 * @return the nome1
	 */
	public String getNome1() {
		return nome1;
	}

	/**
	 * @param nome1
	 *            the nome1 to set
	 */
	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}

	/**
	 * @return the fabricante1
	 */
	public String getFabricante1() {
		return fabricante1;
	}

	/**
	 * @param fabricante1
	 *            the fabricante1 to set
	 */
	public void setFabricante1(String fabricante1) {
		this.fabricante1 = fabricante1;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
