package br.com.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.EventoBusiness;
import br.com.iftm.controller.dto.FiltroEventoDTO;

@RestController
@RequestMapping(value = "evento")
public class EventoRest {

	@Autowired
	private EventoBusiness business;

	// read
	@PostMapping()
	public ResponseEntity<?> read(@RequestBody FiltroEventoDTO filtroEventoDTO) {
		try {
			return ResponseEntity.ok(business.read(filtroEventoDTO));

		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	@GetMapping("/local")
	public ResponseEntity<?> read() {
		try {
			return ResponseEntity.ok(business.readLocal());

		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}
}
