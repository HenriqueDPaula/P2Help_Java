package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OFERTAS")
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

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario idusuario;

	@ManyToOne
	@JoinColumn(name = "IDCATEGORIA")
	private Categoria idcategoria;

	@Column(name = "STATUS", length = 20, nullable = false)
	private char status;

	@ManyToOne
	@JoinColumn(name = "IDSISTEMA")
	private Sistema sistema;

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


	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema idsistema) {
		this.sistema = idsistema;
	}

}
