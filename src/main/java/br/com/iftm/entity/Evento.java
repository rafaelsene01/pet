package br.com.iftm.entity;

import java.util.Date;

import javax.persistence.Entity;

import br.com.iftm.enums.TipoEvento;

@Entity
public class Evento {

	private Integer id;
	private Integer id_usuario;
	private Integer id_pet;
	private TipoEvento tipo_evento;
	private String nome;
	private String descricao;
	private String local;
	private Date data;
	private Boolean status;
	private String img;

}
