package br.com.iftm.dao;

import br.com.iftm.business.BusinessException;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Usuario;

public interface UsuarioDAO {

	Usuario create(Usuario usuario) throws BusinessException;

	AuthUsuario auth(Usuario usuario) throws BusinessException;

	Usuario update(Usuario usuario) throws BusinessException;

}
