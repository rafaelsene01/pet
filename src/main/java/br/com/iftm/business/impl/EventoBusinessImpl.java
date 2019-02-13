package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.EventoBusiness;
import br.com.iftm.controller.dto.FiltroEventoDTO;
import br.com.iftm.dao.EventoDAO;
import br.com.iftm.entity.Evento;

@Service
public class EventoBusinessImpl implements EventoBusiness {

	@Autowired
	private EventoDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Evento> read(FiltroEventoDTO filtroEventoDTO) throws BusinessException {
		return dao.read(filtroEventoDTO);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> readLocal() throws BusinessException {

		return dao.readLocal();
	}

}
