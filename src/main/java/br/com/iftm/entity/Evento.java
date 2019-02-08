package br.com.iftm.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.iftm.enums.TipoEvento;

@Entity
@Table(name = "TB_EVENTO", schema = "GAD", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_EVENTO", columnNames = { "ID_USUARIO", "ID_PET", "NOME_EVENTO" }) })
@SequenceGenerator(name = "SQ_EVENTO", sequenceName = "SQ_EVENTO", initialValue = 1, allocationSize = 1, schema = "GAD")
public class Evento {

	@Id
	@Column(name = "ID_EVENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
	private Integer id;
	@Column(name = "ID_USUARIO")
	private Integer id_usuario;
	@Column(name = "ID_PET")
	private Integer id_pet;
	@Column(name = "TIPO_EVENTO")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo_evento;
	@Column(name = "NOME_EVENTO", length = 100)
	private String nome;
	@Column(name = "DESCRICAO_EVENTO", nullable = true)
	private String descricao;
	@Column(name = "LOCAL_EVENTO")
	private String local;
	@Column(name = "DATA_EVENTO", nullable = true)
	private Date data;
	@Column(name = "STATUS_EVENTO", nullable = true)
	private Boolean status;
	@Column(name = "IMG_EVENTO")
	private String img;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "evento", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId_pet() {
		return id_pet;
	}

	public void setId_pet(Integer id_pet) {
		this.id_pet = id_pet;
	}

	public TipoEvento getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(TipoEvento tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

}
