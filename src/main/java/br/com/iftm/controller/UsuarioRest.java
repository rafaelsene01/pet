package br.com.iftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Evento;
import br.com.iftm.entity.Usuario;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioBusiness business;

	// create
	@PostMapping("/perfil")
	public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {

		try {
			AuthUsuario userAuth = business.createUsuario(usuario);

			return ResponseEntity.ok(userAuth);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// create
	@PostMapping("/perfilUsuario")
	public ResponseEntity<?> readUsuario(@RequestBody AuthUsuario usuario) {

		try {
			Usuario user = business.readUsuario(usuario);

			return ResponseEntity.ok(user);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// auth
	@PostMapping("/authentication")
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
	@PutMapping("/perfil")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {

		try {
			usuario = business.updateUsuario(usuario);

			return ResponseEntity.ok(usuario);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	@PostMapping("/evento")
	public ResponseEntity<?> createEvento(@RequestBody Evento evento) {

		try {
			evento = business.createEvento(evento);

			return ResponseEntity.ok(evento);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}

	@PostMapping()
	public ResponseEntity<?> readMyEvento(@RequestBody AuthUsuario authUsuario) {

		try {
			List<Evento> evento = business.readMyEvento(authUsuario);

			return ResponseEntity.ok(evento);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}

	@PutMapping("/evento")
	public ResponseEntity<?> updateEvento(@RequestBody Evento evento) {

		try {
			evento = business.updateEvento(evento);

			return ResponseEntity.ok(evento);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	@DeleteMapping(value = "/evento/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable("id") Integer id) {

		try {

			business.deleteEvento(id);

			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// delete
	@GetMapping(value = "/evento/{id}")
	public ResponseEntity<?> readEventoId(@PathVariable("id") Integer id) {

		try {
			Evento evento = business.readEventoId(id);

			return ResponseEntity.ok(evento);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}
}
