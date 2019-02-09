package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.FiltroEventoDTO;
import br.com.iftm.entity.Evento;

public interface EventoBusiness {

	List<Evento> read(FiltroEventoDTO filtroEventoDTO) throws BusinessException;

}
