package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "MUNICIPIOS")
public class Municipios implements Serializable {

	public Municipios() {

	}

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -4368862480019055630L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "municipio_sequence")
	@SequenceGenerator(name = "municipio_sequence", sequenceName = "municipio_auto")
	@Column(name = "IDMUNICIPIO", nullable = false)
	private Integer idmunicipio;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	@Column(name = "UF", length = 200, nullable = false)
	private String uf;

	public Integer getIdmunicipio() {
		return idmunicipio;
	}

	public void setIdmunicipio(Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
