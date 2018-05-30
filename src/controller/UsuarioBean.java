package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696022544177517987L;
	private UsuarioService usuarioService;
	private String nome;
	private String email;
	private String senha;
	private Usuario usuario;

	public UsuarioBean() {

	}

	// @PostConstruct
	// public void init() {
	// usuarioService = new UsuarioService();
	// }

	public String login(String email, String senha) {
		String page = "/municipioTeste";
		String pageDown = "/cadastroMunicipio";

		Boolean sucess = usuarioService.login(email, senha);
		if (sucess) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
