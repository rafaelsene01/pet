package br.com.iftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PetBusiness;
import br.com.iftm.entity.Pet;
import br.com.iftm.entity.RacaTipo;

@RestController
@RequestMapping(value = "pet")
public class PetRest {

	@Autowired
	private PetBusiness business;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Pet pet) {

		try {
			List<RacaTipo> racas = business.read(pet);

			return ResponseEntity.ok(racas);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}

}
