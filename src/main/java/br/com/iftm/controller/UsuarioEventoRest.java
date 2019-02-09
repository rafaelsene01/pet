package br.com.iftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioEventoBusiness;
import br.com.iftm.controller.dto.AuthUsuario;
import br.com.iftm.entity.Evento;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioEventoRest {

	@Autowired
	private UsuarioEventoBusiness business;

	@PostMapping("/evento")
	public ResponseEntity<?> create(@RequestBody Evento evento) {

		try {
			evento = business.create(evento);

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
	public ResponseEntity<?> ready(@RequestBody AuthUsuario authUsuario) {

		try {
			List<Evento> evento = business.ready(authUsuario);

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
	public ResponseEntity<?> update(@RequestBody Evento evento) {

		try {
			evento = business.update(evento);

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
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {

			business.delete(id);

			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
