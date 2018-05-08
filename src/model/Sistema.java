package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SISTEMAS")
public class Sistema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_auto")
	@Column(name = "IDUSUARIO", nullable = false)
	private Integer idsistema;
	private String fabricante;
	private String nome;
	
}
