package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Evento;

public interface UsuarioEventoBusiness {

	Evento create(Evento evento) throws BusinessException;

	List<Evento> ready(AuthUsuario authUsuario) throws BusinessException;

	void delete(Integer id) throws BusinessException;

	Evento update(Evento evento) throws BusinessException;

}
