package br.ufrn.imd.sigpessoa.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ufrn.imd.sigpessoa.model.Pessoa;
import br.ufrn.imd.sigpessoa.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/all")
	public ResponseEntity<List<Pessoa>> index() {
		return ResponseEntity.ok(pessoaService.getAll());
	}

	@PostMapping("/store")
	public ResponseEntity<Pessoa> store(@RequestBody Pessoa newPessoa) {
		Pessoa p = pessoaService.createEntity(newPessoa);
		return ResponseEntity.ok(p);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Pessoa> get(@PathVariable("id") Long id) {
		Optional<Pessoa> p = pessoaService.findOne(id);
		return ResponseEntity.of(p);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Pessoa> update(@RequestBody() Pessoa update, @PathVariable("id") Long id) {
		Optional<Pessoa> p = pessoaService.updateEntity(update, id);
		return ResponseEntity.of(p);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		Boolean b = pessoaService.deleteEntity(id);
		if (!b) {
			return new ResponseEntity<Boolean>(b, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(b);
	}
}
