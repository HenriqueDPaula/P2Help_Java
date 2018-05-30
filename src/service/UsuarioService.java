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

	public Boolean login(String email, String senha) {
		return this.usuarioDAO.login(email, senha);
	}
}
