package service;

import javax.inject.Named;

import DAO.MunicipiosDAO;
import model.Municipios;

@Named
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
	 * M�todo para encontrar municipio pelo ID
	 */
	public Municipios FindById(int idmunicipio) {
		return this.municipioDAO.findById(idmunicipio);
	}
}
