package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_TIPO_PET", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_TIPO_PET", columnNames = { "NOME_TIPO_PET" }) })
@SequenceGenerator(name = "SQ_TIPO_PET", sequenceName = "SQ_TIPO_PET", initialValue = 1, allocationSize = 1, schema = "GAD")
public class TipoPet {

	@Id
	@Column(name = "ID_TIPO_PET")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_PET")
	private Integer id;
	@Column(name = "NOME_TIPO_PET", nullable = false)
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
