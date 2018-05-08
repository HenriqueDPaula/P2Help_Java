package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Declarando Entidade e nome da tabela para Mapeamento
 */
@Entity
@Table(name = "SISTEMAS")
public class Sistema {

	/*
	 * Constructor
	 */
	public Sistema() {
		
	}
	
	/*
	 * Id e sequences do banco 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sistema_sequence")
	@SequenceGenerator(name = "sistema_sequence", sequenceName = "sistema_auto")
	@Column(name = "IDSISTEMA", nullable = false)
	private Integer idsistema;
	
	/*
	 * Atributos:
	 * Fabricante e nome do sistema
	 */
	
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	

	/*
	 * Getters and Setters
	 */
	public Integer getIdsistema() {
		return idsistema;
	}

	public void setIdsistema(Integer idsistema) {
		this.idsistema = idsistema;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
