package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PetBusiness;
import br.com.iftm.dao.PetDAO;
import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

@Service
public class PetBusinessImpl implements PetBusiness {

	@Autowired
	private PetDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<RacaTipo> read(Pet pet) throws BusinessException {
		if (pet.getIdTipo() == null)
			throw new BusinessException("ID Raça Requerido!");

		return dao.read(pet);
	}

}
