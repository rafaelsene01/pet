package br.com.iftm.controller.dto;

import br.com.iftm.enums.TipoEvento;

public class FiltroEventoDTO {

	private String local;
	private Integer idPet;
	private TipoEvento tipoEvento;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getIdPet() {
		return idPet;
	}

	public void setIdPet(Integer idPet) {
		this.idPet = idPet;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}
