package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Municipios;
import service.MunicipioService;

@Named("municipioBean")
@RequestScoped
public class MunicipioBean {

	private String nome;
	private String uf;
	private MunicipioService municipioService;
	private Municipios municipio;

	public MunicipioBean() {
		this.municipioService = new MunicipioService();
	}

	/*
	 * Cadstro de Municipio sem verificaçao
	 */
	public String CadastrarMunicipio() {
		this.municipio = new Municipios();
		//this.municipioService = new MunicipioService();
		municipio.setNome(nome);
		municipio.setUf(uf);
		this.municipioService.save(municipio);
		return "/pages/municipioTeste";
	}

	public void selectOne() {
		List <Municipios> mun = new ArrayList();
		Municipios muni = new Municipios();
		muni.setNome("Paraiba");
		muni.setUf("CE");
		mun.add(muni); 
		Municipios muni2 = new Municipios();
		muni2.setNome("rio de Janeiro");
		muni2.setUf("RJ");
		mun.add(muni2);
		
		for (Municipios municipios : mun) {
			municipios.getNome();
		}
	
		
	}
	public MunicipioService getMunicipioService() {
		return municipioService;
	}

	public void setMunicipioService(MunicipioService municipioService) {
		this.municipioService = municipioService;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
