package br.com.iftm.dao.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Usuario createUsuario(Usuario usuario) throws BusinessException {

		sessionFactory.getCurrentSession().save(usuario);
		sessionFactory.getCurrentSession().flush();

		return usuario;
	}

	@Override
	public AuthUsuario auth(Usuario usuario) throws BusinessException {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		criteria = criteria.add(Restrictions.eq("email", usuario.getEmail()));
		criteria = criteria.add(Restrictions.eq("senha", usuario.getSenha()));
		Usuario usuarioDB = (Usuario) criteria.uniqueResult();

		if (usuarioDB != null) {
			String simpleBase64 = Base64.getEncoder()
					.encodeToString((usuarioDB.getEmail() + usuarioDB.getSenha()).getBytes(StandardCharsets.UTF_8));
			AuthUsuario credenciais = new AuthUsuario();
			credenciais.setId(usuarioDB.getId());
			credenciais.setToken(simpleBase64);

			return credenciais;
		}

		return null;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) throws BusinessException {

		sessionFactory.getCurrentSession().update(usuario);
		sessionFactory.getCurrentSession().flush();

		return usuario;
	}

	@Override
	public Evento createEvento(Evento evento) throws BusinessException {

		Date d = new Date();

		evento.setStatus(true);
		evento.setData(d);

		sessionFactory.getCurrentSession().save(evento);
		sessionFactory.getCurrentSession().flush();

		return evento;
	}

	@Override
	public void deleteEvento(Integer id) {

		Evento evento = sessionFactory.getCurrentSession().get(Evento.class, id);
		sessionFactory.getCurrentSession().delete(evento);
	}

	@Override
	public Evento updateEvento(Evento evento) throws BusinessException {

		if (evento.getStatus()) {
			Date d = new Date();
			evento.setData(d);
		}

		sessionFactory.getCurrentSession().update(evento);
		sessionFactory.getCurrentSession().flush();

		return evento;
	}

	@Override
	public List<Evento> readyMyEvento(AuthUsuario authUsuario) throws BusinessException {

		Criteria usuario = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		usuario.add(Restrictions.eq("id", authUsuario.getId()));
		Usuario usuarioDB = (Usuario) usuario.uniqueResult();

		if (usuarioDB != null) {
			String simpleBase64 = Base64.getEncoder()
					.encodeToString((usuarioDB.getEmail() + usuarioDB.getSenha()).getBytes(StandardCharsets.UTF_8));
			if (simpleBase64.equals(authUsuario.getToken())) {
				Criteria eventos = sessionFactory.getCurrentSession().createCriteria(Evento.class);
				eventos.add(Restrictions.eq("id_usuario", authUsuario.getId()));

				return eventos.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();// dados vultando duplicado
																							// tive que usar o retorno
																							// deata maneira
			}
		}

		return null;
	}

}
