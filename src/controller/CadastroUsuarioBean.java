package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.UsuarioService;
import vo.Usuario;

@ViewScoped
@ManagedBean(name = "cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696022544177517987L;
	private UsuarioService usuarioService;
	private String nome;
	private Usuario usuario;

	public CadastroUsuarioBean() {
		usuario = new Usuario();
	}

	@PostConstruct
	public void init() {
		usuarioService = new UsuarioService();
	}
	
	
	public void cadastrar() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setIdusuario(1);
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
