
package model;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260819040137629327L;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "idcontratacao")
	private Contratacao idcontratacao;

	@Column(name = "NOTA_ATENDIMENTO", nullable = true)
	private Integer atendimento;

	@Column(name = "NOTA_SERVICO, nullable = true ")
	private Integer servico;

	@Column(name = "COMENTARIO", nullable = true)
	private String comentario;

	public Avaliacao() {

	}

	public Contratacao getIdcontratacao() {
		return idcontratacao;
	}

	public void setIdcontratacao(Contratacao idcontratacao) {
		this.idcontratacao = idcontratacao;
	}

	public Integer getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atendimento == null) ? 0 : atendimento.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((idcontratacao == null) ? 0 : idcontratacao.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Avaliacao))
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (atendimento == null) {
			if (other.atendimento != null)
				return false;
		} else if (!atendimento.equals(other.atendimento))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idcontratacao == null) {
			if (other.idcontratacao != null)
				return false;
		} else if (!idcontratacao.equals(other.idcontratacao))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}

	// Equals and HashCode
}