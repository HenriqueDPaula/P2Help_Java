package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Usuario;
import service.UsuarioService;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696022544177517987L;
	private UsuarioService usuarioService;
	private String nome;
	private Usuario usuario;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarioService = new UsuarioService();
	}

	@PostConstruct
	public void init() {
		usuarioService = new UsuarioService();
	}

	public void cadastrar() {

		this.usuario = new Usuario();
		this.usuarioService = new UsuarioService();
		usuarioService.save(usuario);
	}

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

}
