package br.com.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Usuario;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioBusiness business;

	// create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {

		try {
			usuario = business.create(usuario);

			return ResponseEntity.ok(usuario);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// auth
	@PostMapping()
	public ResponseEntity<?> auth(@RequestBody Usuario usuario) {

		try {
			AuthUsuario auth = business.auth(usuario);

			return ResponseEntity.ok(auth);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {

		try {
			usuario = business.update(usuario);

			return ResponseEntity.ok(usuario);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}
}
