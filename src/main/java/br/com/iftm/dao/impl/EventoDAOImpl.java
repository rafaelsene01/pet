package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.FiltroEventoDTO;
import br.com.iftm.dao.EventoDAO;
import br.com.iftm.entity.Evento;

@Repository
public class EventoDAOImpl implements EventoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Evento> read(FiltroEventoDTO filtroEventoDTO) throws BusinessException {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Evento.class);

		criteria.add(Restrictions.eq("status", true));

		if (filtroEventoDTO.getTipoEvento() != null)
			criteria.add(Restrictions.eq("tipo_evento", filtroEventoDTO.getTipoEvento()));
		if (filtroEventoDTO.getIdPet() != null)
			criteria.add(Restrictions.eq("id_pet", filtroEventoDTO.getIdPet()));
		if (!StringUtils.isEmpty(filtroEventoDTO.getLocal()))
			criteria.add(Restrictions.like("local", filtroEventoDTO.getLocal(), MatchMode.ANYWHERE).ignoreCase());

		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();// dados vultando duplicado tive que
																					// usar o retorno deata maneira
	}

	@Override
	public List<String> readLocal() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Evento.class);
		criteria.setProjection(Projections.groupProperty("local"));

		return criteria.list();
	}

}
