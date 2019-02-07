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
@Table(name = "TB_RACA_TIPO", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_RACA_TIPO", columnNames = { "NOME_RACA_TIPO" }) })
@SequenceGenerator(name = "SQ_RACA_TIPO", sequenceName = "SQ_RACA_TIPO", initialValue = 1, allocationSize = 1, schema = "GAD")
public class RacaTipo {

	@Id
	@Column(name = "ID_RACA_TIPO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RACA_TIPO")
	private Integer id;
	@Column(name = "NOME_RACA_TIPO", nullable = false)
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