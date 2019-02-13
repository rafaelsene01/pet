package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.Usuario;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private UsuarioDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AuthUsuario createUsuario(Usuario usuario) throws BusinessException {
		if (StringUtils.isEmpty(usuario.getNome()))
			throw new BusinessException("Nome Requerido!");
		if (usuario.getNome().length() >= 100)
			throw new BusinessException("Tamanho do nome excedido");
		if (StringUtils.isEmpty(usuario.getEmail()))
			throw new BusinessException("Email Requerido!");
		if (StringUtils.isEmpty(usuario.getSenha()))
			throw new BusinessException("Senha Requerido!");

		return dao.createUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario readUsuario(AuthUsuario usuario) throws BusinessException {
		if (usuario.getId() == null)
			throw new BusinessException("ID Requerido!");
		if (StringUtils.isEmpty(usuario.getToken()))
			throw new BusinessException("TOKEN Requerido!");

		return dao.readUsuario(usuario);
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
	public Usuario updateUsuario(Usuario usuario) throws BusinessException {

		if (StringUtils.isEmpty(usuario.getId()))
			throw new BusinessException("Id Requerido!");
		if (StringUtils.isEmpty(usuario.getNome()))
			throw new BusinessException("Nome Requerido!");
		if (StringUtils.isEmpty(usuario.getEmail()))
			throw new BusinessException("Email Requerido!");
		if (StringUtils.isEmpty(usuario.getSenha()))
			throw new BusinessException("Senha Requerido!");

		return dao.updateUsuario(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Evento createEvento(Evento evento) throws BusinessException {
		if (evento.getId_usuario() == null)
			throw new BusinessException("ID_USUARIO Requerido!");
		if (evento.getId_pet() == null)
			throw new BusinessException("ID_PET Requerido!");
		if (evento.getTipo_evento() == null)
			throw new BusinessException("TIPO_EVENTO Requerido!");
		if (StringUtils.isEmpty(evento.getNome()))
			throw new BusinessException("NOME Requerido!");
		if (evento.getNome().length() > 100)
			throw new BusinessException("TAMANHO_NOME EXCEDIDO!");
		if (StringUtils.isEmpty(evento.getLocal()))
			throw new BusinessException("LOCAL Requerido!");
		if (StringUtils.isEmpty(evento.getImg()))
			throw new BusinessException("IMG Requerido!");
		if (evento.getTelefone() == null || evento.getTelefone().isEmpty())
			throw new BusinessException("TELEFONE Requerido!");

		for (Telefone telefone : evento.getTelefone()) {
			if (telefone.getDdd() == null)
				throw new BusinessException("DDD invalido");
			if (telefone.getNumero() == null)
				throw new BusinessException("Numero Telefone invalido");

			telefone.setEvento(evento);
			;
		}

		return dao.createEvento(evento);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Evento updateEvento(Evento evento) throws BusinessException {
		if (evento.getId() == null)
			throw new BusinessException("ID Requerido!");
		if (evento.getId_usuario() == null)
			throw new BusinessException("ID_USUARIO Requerido!");
		if (evento.getId_pet() == null)
			throw new BusinessException("ID_PET Requerido!");
		if (evento.getTipo_evento() == null)
			throw new BusinessException("TIPO_EVENTO Requerido!");
		if (StringUtils.isEmpty(evento.getNome()))
			throw new BusinessException("NOME Requerido!");
		if (evento.getNome().length() > 100)
			throw new BusinessException("TAMANHO_NOME EXCEDIDO!");
		if (StringUtils.isEmpty(evento.getLocal()))
			throw new BusinessException("LOCAL Requerido!");
		if (StringUtils.isEmpty(evento.getImg()))
			throw new BusinessException("IMG Requerido!");
		if (evento.getTelefone() == null || evento.getTelefone().isEmpty())
			throw new BusinessException("TELEFONE Requerido!");

		for (Telefone telefone : evento.getTelefone()) {
			if (telefone.getDdd() == null)
				throw new BusinessException("DDD invalido");
			if (telefone.getNumero() == null)
				throw new BusinessException("Numero Telefone invalido");

			telefone.setEvento(evento);
			;
		}

		return dao.updateEvento(evento);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteEvento(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("ID Requerido!");
		}

		dao.deleteEvento(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evento> readMyEvento(AuthUsuario authUsuario) throws BusinessException {

		if (authUsuario.getId() == null)
			throw new BusinessException("ID Requerido!");
		if (StringUtils.isEmpty(authUsuario.getToken()))
			throw new BusinessException("TOKEN Requerido!");

		return dao.readMyEvento(authUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Evento readEventoId(Integer id) throws BusinessException {

		if (id == null)
			throw new BusinessException("ID Requerido!");

		return dao.readEventoId(id);
	}

}
