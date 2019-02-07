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
@Table(name = "TB_USUARIO", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_USUARIO", columnNames = { "EMAIL_USUARIO" }) })
@SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", initialValue = 1, allocationSize = 1, schema = "GAD")
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
	private Integer id;
	@Column(name = "NOME_USUARIO", nullable = false, length = 100)
	private String nome;
	@Column(name = "EMAIL_USUARIO", nullable = false)
	private String email;
	@Column(name = "SENHA_USUARIO", nullable = false)
	private String senha;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
