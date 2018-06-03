package service;

import dao.UsuarioDAO;
import model.Usuario;

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

	public Usuario login(String email, String senha) {
		return this.usuarioDAO.login(email, senha);
	}
}
