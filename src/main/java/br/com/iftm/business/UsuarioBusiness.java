package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Usuario;

public interface UsuarioBusiness {

	Usuario createUsuario(Usuario usuario) throws BusinessException;

	AuthUsuario auth(Usuario usuario) throws BusinessException;

	Usuario updateUsuario(Usuario usuario) throws BusinessException;

	Evento createEvento(Evento evento) throws BusinessException;

	List<Evento> readyMyEvento(AuthUsuario authUsuario) throws BusinessException;

	void deleteEvento(Integer id) throws BusinessException;

	Evento updateEvento(Evento evento) throws BusinessException;
}
