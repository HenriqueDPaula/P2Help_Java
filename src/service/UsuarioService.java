package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	public UsuarioService() {

		this.usuarioDAO = new UsuarioDAO();
	}

	public boolean save(Usuario usuario) {
		// TODO Auto-generated method stub
		if (this.usuarioDAO.save(usuario)) {
			return true;
		} else {
			return false;
		}

	}

	public Usuario findById(int idusuario) {
		return this.usuarioDAO.findById(idusuario);
	}

	public Usuario login(String email, String senha) {
		return this.usuarioDAO.login(email, senha);
	}

	public void atualizar(Usuario usuario) {
		this.usuarioDAO.atualizar(usuario);
	}
}
