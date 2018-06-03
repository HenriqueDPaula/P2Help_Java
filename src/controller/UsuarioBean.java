package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioDAO;
import model.Municipios;
import model.Usuario;
import service.MunicipioService;
import service.UsuarioService;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696022544177517987L;
	private String nome;
	private String senha;
	private String senhaConfirm;
	private String endereco;
	private String complemento;
	private String rg;
	private String rgEmissor;
	private Municipios municipio;
	private String bairro;
	private String email;
	private String numero;
	private String cpf;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private MunicipioService municipioService;

	public UsuarioBean() {
		this.municipioService = new MunicipioService();
		this.usuarioService = new UsuarioService();
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

	// public String cadastrarUsuario() {
	// Usuario usuarioM = preencherUsuario();
	// usuarioService.save(usuarioM);
	// return "";
	// }

	public String cadastrar() {
		usuario = new Usuario();
		usuario.setBairro(bairro);
		usuario.setComplemento(complemento);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		usuario.setNumero(numero);
		municipio = municipioService.FindById(61);
		usuario.setMunicipio(municipio);
		usuario.setNome(nome);
		usuario.setRg(rg);
		usuario.setRgEmissor(rgEmissor);
		usuario.setSenha(senha);
		usuarioService.save(usuario);

		return "";
	}

	// public void cadastrar() {
	//
	// this.usuario = new Usuario();
	// this.usuarioService = new UsuarioService();
	// usuarioService.save(usuario);
	// }

	public String checkSenha() {
		if (senha.equals(senhaConfirm)) {
			return senha;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha inserida não confere!", ""));
			return senha;
		}

	}

	// public String checkCpf() {
	// usuarioService.
	// if(senha.equals(senhaConfirm)) {
	// return senha;
	// }else {
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha inserida não confere!",
	// ""));
	// return senha;
	// }
	//
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public String getSenhaConfirm() {
		return senhaConfirm;
	}

	public void setSenhaConfirm(String senhaConfirm) {
		this.senhaConfirm = senhaConfirm;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public MunicipioService getMunicipioService() {
		return municipioService;
	}

	public void setMunicipioService(MunicipioService municipioService) {
		this.municipioService = municipioService;
	}

}
