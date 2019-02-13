package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.business.BusinessException;
import br.com.iftm.entity.TipoPet;

public interface TipoPetDAO {

	List<TipoPet> read() throws BusinessException;

}
