package service;

import javax.inject.Named;

import DAO.MunicipiosDAO;
import model.Municipios;

@Named
public class MunicipioService {

	private MunicipiosDAO municipioDAO;

	public MunicipioService() {

		this.municipioDAO = new MunicipiosDAO();
	}

	public void save(Municipios municipio) {
		// TODO Auto-generated method stub
		this.municipioDAO.save(municipio);
	}
	
	public Municipios FindById(int idmunicipio) {
		return this.municipioDAO.findById(idmunicipio);
	}
}
