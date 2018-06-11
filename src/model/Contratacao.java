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

	private Oferta oferta;

	private Usuario usuario;

	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CONTRATACAO", nullable = false)
	private Date dataContratacao;

	@Column(name = "STATUS", length = 20, nullable = false)
	private char status;

}
