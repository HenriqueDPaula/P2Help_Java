package service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import DAO.MunicipiosDAO;
import model.Municipios;

@ManagedBean(name = "municipioService")
public class MunicipioService {

	private MunicipiosDAO municipioDAO;

	/*
	 * Construtor instanciando a ClasseDAO
	 */
	public MunicipioService() {

		this.municipioDAO = new MunicipiosDAO();
	}

	/*
	 * M�todo para cadastrar Usuario
	 */
	public void save(Municipios municipio) {
		// TODO Auto-generated method stub
		this.municipioDAO.save(municipio);
	}

	/*
	 * Encontrar municipio pelo ID
	 */
	public Municipios FindById(int idmunicipio) {
		return this.municipioDAO.findById(idmunicipio);
	}

	/*
	 * Retorno de uma lista de Municipios
	 */
	public List<Municipios> listar() {
		return this.municipioDAO.listar();
	}
}
