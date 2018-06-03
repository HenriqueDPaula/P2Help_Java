package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Sistema;
import service.SistemaService;

@Named("sistemaBean")
@RequestScoped
public class SistemaBean {

	private String nome;
	private String fabricante;
	private SistemaService sistemaService;
	private Sistema sistema;

	public SistemaBean() {
		this.sistemaService = new SistemaService();
	}

	/*
	 * Cadstro de Sistema sem verificaçao
	 */
	public String CadastrarSistema() {
		this.sistema = new Sistema();
		sistema.setNome(nome);
		sistema.setFabricante(fabricante);
		this.sistemaService.save(sistema);
		return "/pages/municipioTeste";
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

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

}
