package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Evento;

public interface EventoBusiness {

	Evento create(Evento evento) throws BusinessException;

	List<Evento> read() throws BusinessException;

}
