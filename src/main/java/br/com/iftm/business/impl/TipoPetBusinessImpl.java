package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.TipoPetBusiness;
import br.com.iftm.dao.TipoPetDAO;
import br.com.iftm.entity.TipoPet;

@Service
@Transactional
public class TipoPetBusinessImpl implements TipoPetBusiness {

	@Autowired
	private TipoPetDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoPet> read() throws BusinessException {

		return dao.read();
	}

}
