package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import DAO.UsuarioDAO;
import model.Usuario;
import service.UsuarioService;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696022544177517987L;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	public UsuarioBean() {

	}

	// @PostConstruct
	// public void init() {
	// usuarioService = new UsuarioService();
	// }

	public String login() {
		String page = "/municipioTeste";
		String pageDown = "/cadastroMunicipio";

		usuario = usuarioDAO.login();
		if (usuario != null) {
			return page;

		} else {
			return pageDown;
		}

	}

	// public void cadastrar() {
	//
	// this.usuario = new Usuario();
	// this.usuarioService = new UsuarioService();
	// usuarioService.save(usuario);
	// }

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
