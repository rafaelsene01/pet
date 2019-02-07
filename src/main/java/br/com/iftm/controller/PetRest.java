package br.com.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

@RestController
@RequestMapping(value = "pet")
public class PetRest {

	@Autowired
	private Pet business;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Pet pet) {

		try {
			RacaTipo pet = business.read(pet);

			return ResponseEntity.ok(pet);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}

}
