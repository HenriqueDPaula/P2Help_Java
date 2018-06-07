package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import dao.UsuarioDAO;
import model.Municipios;
import model.Usuario;
import service.MunicipioService;
import service.UsuarioService;

@SessionScoped
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
	private List<SelectItem> MunicipioSelect;

	public UsuarioBean() {
		this.municipioService = new MunicipioService();
		this.usuarioService = new UsuarioService();
	}

	public String login() {
		Usuario usuario = usuarioService.login(email, senha);
		if (usuario != null) {
			setUsuario(usuario);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioL", usuario);
			return "pages/pageUsuario";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Usuário ou senha não conferem."));
			return "";
		}

	}

	public Usuario usuario() {
		usuario = new Usuario();
		usuario.setBairro(bairro);
		usuario.setComplemento(complemento);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		usuario.setNumero(numero);
		usuario.setMunicipio(municipio);
		usuario.setNome(nome);
		usuario.setRg(rg);
		usuario.setRgEmissor(rgEmissor);
		usuario.setSenha(senha);
		return usuario;

	}

	public boolean cadastrar() {
		Usuario usuarioP = usuario();
		if (usuarioP != null) {
			if (usuarioService.save(usuarioP)) {

			}
			return true;
		} else {
			return false;
		}

	}

	public String atualizar() {
		this.usuario = usuarioService.findById(this.usuario.getIdusuario());
		return "atualizarUsuario";
	}

	public String validarSenhas() {
		if (senha.equals(senhaConfirm)) {
			if (cadastrar()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Usuario cadastrado", " faça login para continuar"));
			}
			return ";login";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "As senhas devem ser iguais."));
			return "";
		}
	}

	public String atualizarConfirm() {

		usuarioService.atualizar(this.usuario);

		return "pageUsuario";
	}

	public List<SelectItem> selectMunicipios() {
		if (MunicipioSelect == null) {
			MunicipioSelect = new ArrayList<SelectItem>();
			List<Municipios> listaMunicipios = new ArrayList<Municipios>();
			listaMunicipios = municipioService.listar();
			if (listaMunicipios != null && !listaMunicipios.isEmpty()) {
				SelectItem item;
				for (Municipios municipios : listaMunicipios) {
					item = new SelectItem(municipios, municipios.getNome());
					MunicipioSelect.add(item);
				}
			}

		}
		return MunicipioSelect;
	}

	public String detalheMunicipio() {

		return usuario.getMunicipio().getNome();
	}

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

	/**
	 * @return the municipioSelect
	 */
	public List<SelectItem> getMunicipioSelect() {
		return MunicipioSelect;
	}

	/**
	 * @param municipioSelect
	 *            the municipioSelect to set
	 */
	public void setMunicipioSelect(List<SelectItem> municipioSelect) {
		MunicipioSelect = municipioSelect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MunicipioSelect == null) ? 0 : MunicipioSelect.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((municipioService == null) ? 0 : municipioService.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((rgEmissor == null) ? 0 : rgEmissor.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaConfirm == null) ? 0 : senhaConfirm.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioDAO == null) ? 0 : usuarioDAO.hashCode());
		result = prime * result + ((usuarioService == null) ? 0 : usuarioService.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioBean other = (UsuarioBean) obj;
		if (MunicipioSelect == null) {
			if (other.MunicipioSelect != null)
				return false;
		} else if (!MunicipioSelect.equals(other.MunicipioSelect))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (municipioService == null) {
			if (other.municipioService != null)
				return false;
		} else if (!municipioService.equals(other.municipioService))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (rgEmissor == null) {
			if (other.rgEmissor != null)
				return false;
		} else if (!rgEmissor.equals(other.rgEmissor))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaConfirm == null) {
			if (other.senhaConfirm != null)
				return false;
		} else if (!senhaConfirm.equals(other.senhaConfirm))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioDAO == null) {
			if (other.usuarioDAO != null)
				return false;
		} else if (!usuarioDAO.equals(other.usuarioDAO))
			return false;
		if (usuarioService == null) {
			if (other.usuarioService != null)
				return false;
		} else if (!usuarioService.equals(other.usuarioService))
			return false;
		return true;
	}

}