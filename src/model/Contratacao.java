package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Contratacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3450470364290060049L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contratacao_sequence")
	@SequenceGenerator(name = "contratacao_sequence", sequenceName = "contratacao_sequence")
	@Column(name = "IDCONTRATACAO", nullable = false)
	private Integer idcontratacao;

	@JoinColumn(name = "iDOFERTA", nullable = false)
	private Oferta oferta;

	@JoinColumn(name = "IDUSUARIO", nullable = false)
	private Usuario usuario;

	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CONTRATACAO", nullable = false)
	private Date dataContratacao;

	@Column(name = "STATUS", length = 20, nullable = false)
	private char status;

	/**
	 * @return the idcontratacao
	 */
	public Integer getIdcontratacao() {
		return idcontratacao;
	}

	/**
	 * @param idcontratacao the idcontratacao to set
	 */
	public void setIdcontratacao(Integer idcontratacao) {
		this.idcontratacao = idcontratacao;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the dataContratacao
	 */
	public Date getDataContratacao() {
		return dataContratacao;
	}

	/**
	 * @param dataContratacao the dataContratacao to set
	 */
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
