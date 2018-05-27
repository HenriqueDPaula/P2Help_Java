package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/*
 * Entidade e nome da tabela para mapeamento
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119457957054631514L;
	/*
	 * Id, valor e qual sequence informada
	 */

	/*
	 * Atributos a seres settados: Nome, CPF, Rg, Rg Emissor, Endereço, numero,
	 * bairro, complemento, e o id do municipio(fk)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_auto")
	@Column(name = "IDUSUARIO", nullable = false)
	private Integer idusuario;

	@Column(name = "SENHA", length = 30, nullable = false)
	private String senha;
	@Column(name = "EMAIL", length = 200, nullable = false)
	private String email;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	@Column(name = "CPF", length = 200, nullable = false)
	private String cpf;

	@Column(name = "RG", length = 200, nullable = false)
	private String rg;

	@Column(name = "RG_EMISSOR", length = 200, nullable = false)
	private String rgEmissor;

	@Column(name = "ENDERECO", length = 200, nullable = false)
	private String endereco;

	@Column(name = "NUMERO", length = 200, nullable = false)
	private String numero;

	@Column(name = "BAIRRO", length = 200, nullable = true)
	private String bairro;

	@Column(name = "COMPLEMENTO", length = 200, nullable = true)
	private String complemento;

	@ManyToOne
	@JoinColumn(name = "idmunicipio")
	private Municipios municipio;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "CADASTRO_USUARIO_PERMISSAO", uniqueConstraints = {
			@UniqueConstraint(columnNames = { "USUARIO", "PERMISSAO" }) }, joinColumns = @JoinColumn(name = "USUARIO"))
	@Column(name = "PERMISSAO", length = 50)
	private Set<String> permissao;

	/*
	 * Constructor
	 */
	public Usuario() {

	}

	/*
	 * Getters and Setters
	 */
	public Integer getIdusuario() {
		return idusuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha.trim();
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the permissao
	 */
	public Set<String> getPermissao() {
		return permissao;
	}

	/**
	 * @param permissao
	 *            the permissao to set
	 */
	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		return result;
	}

}
