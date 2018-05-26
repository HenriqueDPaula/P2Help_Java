package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OFERTA")
public class Oferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8683267419897556649L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "oferta_sequence")
	@SequenceGenerator(name = "oferta_sequence", sequenceName = "oferta_auto")
	@Column(name = "IDOFERTA", nullable = false)
	private Integer idoferta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_OFERTA", nullable = false)
	private Date dataOferta;

	@Column(name = "VALOR_HORA", nullable = false)
	private float valorHora;

	@Column(name = "TITULO", length = 200, nullable = false)
	private String titulo;

	@Column(name = "DESCRICAO", length = 400, nullable = true)
	private String descricao;

	@Column(name = "IDUSUARIO", nullable = false)
	private Integer idusuario;

	@Column(name = "IDCATEGORIA", nullable = false)
	private Integer idcategoria;

	@Column(name = "STATUS", length = 1, nullable = false)
	private char status;

	@Column(name = "IDSISTEMA", nullable = false)
	private Integer idsistema;

	public Oferta() {

	}

	public Integer getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(Integer idoferta) {
		this.idoferta = idoferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Integer getIdsistema() {
		return idsistema;
	}

	public void setIdsistema(Integer idsistema) {
		this.idsistema = idsistema;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
