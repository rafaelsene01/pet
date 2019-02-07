package br.com.iftm.dao.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Usuario create(Usuario usuario) throws BusinessException {

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
	public Usuario update(Usuario usuario) throws BusinessException {

		sessionFactory.getCurrentSession().update(usuario);
		sessionFactory.getCurrentSession().flush();

		return usuario;
	}

}
