package vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "USU_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119457957054631514L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_SEQ")
	@Column(name = "IDUSUARIO", nullable = false)
	private int idusuario;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	public Usuario() {

	}

	public int getIdusuario() {
		return idusuario;
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

}
