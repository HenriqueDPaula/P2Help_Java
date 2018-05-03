package vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119457957054631514L;

	@Id
	@Column(name = "IDUSUARIO", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idusuario;

	@Column(name = "NOME", length = 200, nullable = false)
	private String nome;

	public Usuario() {

	}

	public Integer getIdusuario() {
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
