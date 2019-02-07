package br.com.iftm.business;

import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Usuario;

public interface UsuarioBusiness {

	Usuario create(Usuario usuario) throws BusinessException;

	AuthUsuario auth(Usuario usuario) throws BusinessException;

	Usuario update(Usuario usuario) throws BusinessException;
}
