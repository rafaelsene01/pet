package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.business.BusinessException;
import br.com.iftm.entity.Evento;

public interface EventoDAO {

	Evento create(Evento evento) throws BusinessException;

	List<Evento> read() throws BusinessException;
}
