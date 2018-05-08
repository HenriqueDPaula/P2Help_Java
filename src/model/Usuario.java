package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_auto")
	@Column(name = "IDUSUARIO", nullable = false)
	private Integer idusuario;

	/*
	 * Atributos a seres settados:
	 * Nome, CPF, Rg, Rg Emissor, Endereço, numero, bairro, complemento, e o id do municipio(fk)
	 */
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

}
