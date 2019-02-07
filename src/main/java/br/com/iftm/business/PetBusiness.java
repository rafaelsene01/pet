package br.com.iftm.business;

import br.com.iftm.entity.Pet;

public interface PetBusiness {

	Pet read(Pet pet) throws BusinessException;

}
