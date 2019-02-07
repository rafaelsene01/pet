package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoPet;

public interface TipoPetBusiness {

	List<TipoPet> read() throws BusinessException;
}
