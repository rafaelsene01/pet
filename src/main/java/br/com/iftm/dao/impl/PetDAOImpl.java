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

		/*
		 * todasRacas.add( Restrictions.
		 * sqlRestriction("select raca.id_raca_tipo, raca.nome_raca_tipo from GAD.tb_raca_tipo raca,"
		 * + " GAD.tb_pet pet where pet.id_tipo_pet = " + pet.getIdTipo() +
		 * " and pet.id_raca_tipo = raca.id_raca_tipo"));
		 * 
		 * todasRacas.addQueryHint(
		 * "select raca.id_raca_tipo, raca.nome_raca_tipo from GAD.tb_raca_tipo raca, GAD.tb_pet pet "
		 * + "where pet.id_tipo_pet = " + pet.getIdTipo() +
		 * " and pet.id_raca_tipo = raca.id_raca_tipo");
		 */

		List<RacaTipo> animais = new ArrayList<>();

		// Arruma a condicao abaixo em uma query

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
