package br.com.iftm.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Usuario;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private UsuarioDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario create(Usuario usuario) throws BusinessException {
		if (StringUtils.isEmpty(usuario.getNome()))
			throw new BusinessException("Nome Requerido!");
		if (usuario.getNome().length() >= 100)
			throw new BusinessException("Tamanho do nome excedido");
		if (StringUtils.isEmpty(usuario.getEmail()))
			throw new BusinessException("Email Requerido!");
		if (StringUtils.isEmpty(usuario.getSenha()))
			throw new BusinessException("Senha Requerido!");

		return dao.create(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AuthUsuario auth(Usuario usuario) throws BusinessException {

		if (StringUtils.isEmpty(usuario.getEmail()))
			throw new BusinessException("Email Requerido!");
		if (StringUtils.isEmpty(usuario.getSenha()))
			throw new BusinessException("Senha Requerido!");

		return dao.auth(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario update(Usuario usuario) throws BusinessException {

		if (StringUtils.isEmpty(usuario.getId()))
			throw new BusinessException("Id Requerido!");
		if (StringUtils.isEmpty(usuario.getNome()))
			throw new BusinessException("Nome Requerido!");
		if (StringUtils.isEmpty(usuario.getEmail()))
			throw new BusinessException("Email Requerido!");
		if (StringUtils.isEmpty(usuario.getSenha()))
			throw new BusinessException("Senha Requerido!");

		return dao.update(usuario);
	}

}
