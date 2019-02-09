package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.FiltroEventoDTO;
import br.com.iftm.entity.Evento;

public interface EventoDAO {

	List<Evento> read(FiltroEventoDTO filtroEventoDTO) throws BusinessException;

}
