package service;

import javax.inject.Named;

import DAO.UsuarioDAO;
import model.Usuario;

@Named
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	public UsuarioService() {

		this.usuarioDAO = new UsuarioDAO();
	}

	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioDAO.save(usuario);

	}
	
	public Usuario findById(int idusuario) {
		return this.usuarioDAO.findById(idusuario);
	}

	public Usuario login() {
		return this.usuarioDAO.login();
	}
}
