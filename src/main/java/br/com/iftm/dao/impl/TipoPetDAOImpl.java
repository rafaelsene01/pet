package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoPetDAO;
import br.com.iftm.entity.TipoPet;

@Repository
public class TipoPetDAOImpl implements TipoPetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TipoPet> read() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoPet.class);

		return criteria.list();
	}

}
