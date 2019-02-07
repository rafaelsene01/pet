package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_PET", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_PET", columnNames = { "ID_TIPO_PET", "ID_RACA_TIPO" }) })
@SequenceGenerator(name = "SQ_PET", sequenceName = "SQ_PET", initialValue = 1, allocationSize = 1, schema = "GAD")
@JsonIgnoreProperties(value = { "prestadorServico" })
public class Pet {

	@Id
	@Column(name = "ID_PET")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PET")
	private Integer id;
	@Column(name = "ID_TIPO_PET", nullable = false)
	private Integer idTipo;
	@Column(name = "ID_RACA_TIPO", nullable = false)
	private Integer idRaca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Integer getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Integer idRaca) {
		this.idRaca = idRaca;
	}

}