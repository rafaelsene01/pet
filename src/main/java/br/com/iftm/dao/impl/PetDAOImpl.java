package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PetDAO;
import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

@Repository
public class PetDAOImpl implements PetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RacaTipo> read(Pet pet) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pet.class);
		criteria.add(Restrictions.eq("idTipo", pet.getIdTipo()));
		List<Pet> filtroPet = criteria.list();

		Criteria todasRacas = sessionFactory.getCurrentSession().createCriteria(RacaTipo.class);
		List<RacaTipo> filtroRacas = todasRacas.list();

		List<RacaTipo> animais = new ArrayList<>();

		for (int i = 0; i < filtroPet.size(); i++) {
			for (int j = 0; j < filtroRacas.size(); j++) {
				if (filtroPet.get(i).getIdRaca() == filtroRacas.get(j).getId()) {
					animais.add(filtroRacas.get(j));
					break;
				}

			}
		}

		return animais;
	}

	@Override
	public Pet readId(Pet pet) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pet.class);
		criteria.add(Restrictions.eq("idTipo", pet.getIdTipo()));
		criteria.add(Restrictions.eq("idRaca", pet.getIdRaca()));

		return (Pet) criteria.uniqueResult();
	}

}
