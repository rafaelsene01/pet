package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Usuario;

public interface UsuarioDAO {

	Usuario createUsuario(Usuario usuario) throws BusinessException;

	AuthUsuario auth(Usuario usuario) throws BusinessException;

	Usuario updateUsuario(Usuario usuario) throws BusinessException;

	Evento createEvento(Evento evento) throws BusinessException;

	List<Evento> readyMyEvento(AuthUsuario authUsuario) throws BusinessException;

	void deleteEvento(Integer id) throws BusinessException;

	Evento updateEvento(Evento evento) throws BusinessException;

}
