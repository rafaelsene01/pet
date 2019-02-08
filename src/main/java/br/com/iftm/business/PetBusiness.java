package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

public interface PetBusiness {

	List<RacaTipo> read(Pet pet) throws BusinessException;

	Pet readId(Pet pet) throws BusinessException;

}
