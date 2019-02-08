package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_TELEFONE", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_TELEFONE", columnNames = { "ID_EVENTO", "DDD_TELEFONE", "NUM_TELEFONE" }) })
@SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1, schema = "GAD")
@JsonIgnoreProperties(value = { "evento" })
public class Telefone {

	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
	private Integer id;

	@Column(name = "DDD_TELEFONE", nullable = false)
	private Integer ddd;

	@Column(name = "NUM_TELEFONE", nullable = false)
	private Integer numero;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Evento.class)
	@JoinColumn(name = "ID_EVENTO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_TELEF_TB_EVENTO"))
	private Evento evento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
