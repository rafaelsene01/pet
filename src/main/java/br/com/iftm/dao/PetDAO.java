package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

public interface PetDAO {

	List<RacaTipo> read(Pet pet);

	Pet readId(Pet pet);

}
