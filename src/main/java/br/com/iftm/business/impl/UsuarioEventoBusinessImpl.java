package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioEventoBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.dao.UsuarioEventoDAO;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Telefone;

@Service
public class UsuarioEventoBusinessImpl implements UsuarioEventoBusiness {

	@Autowired
	private UsuarioEventoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Evento create(Evento evento) throws BusinessException {
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

		return dao.create(evento);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Evento update(Evento evento) throws BusinessException {
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

		return dao.update(evento);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("ID Requerido!");
		}

		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evento> ready(AuthUsuario authUsuario) throws BusinessException {

		if (authUsuario.getId() == null)
			throw new BusinessException("ID Requerido!");
		if (StringUtils.isEmpty(authUsuario.getToken()))
			throw new BusinessException("TOKEN Requerido!");

		return dao.ready(authUsuario);
	}
}
