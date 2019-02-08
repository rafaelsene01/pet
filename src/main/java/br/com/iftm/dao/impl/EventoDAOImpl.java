package br.com.iftm.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.business.BusinessException;
import br.com.iftm.dao.EventoDAO;
import br.com.iftm.entity.Evento;

@Repository
public class EventoDAOImpl implements EventoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Evento create(Evento evento) throws BusinessException {

		Date d = new Date();

		evento.setStatus(true);
		evento.setData(d);

		sessionFactory.getCurrentSession().save(evento);
		sessionFactory.getCurrentSession().flush();

		return evento;
	}

	@Override
	public List<Evento> read() throws BusinessException {
		return sessionFactory.getCurrentSession().createCriteria(Evento.class).list();
	}

}
