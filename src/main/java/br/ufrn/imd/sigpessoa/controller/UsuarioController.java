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
import br.ufrn.imd.sigpessoa.model.Usuario;
import br.ufrn.imd.sigpessoa.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> all() {
		return ResponseEntity.ok(usuarioService.getAll());
	}

	@PostMapping("/store")
	public ResponseEntity<Usuario> store(@RequestBody Usuario newUsuario) {
		Usuario u = usuarioService.createEntity(newUsuario);
		return new ResponseEntity<Usuario>(u, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Usuario> get(@PathVariable("id") Long id) {
		Optional<Usuario> u = usuarioService.findOne(id);
		return ResponseEntity.of(u);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> update(@RequestBody() Usuario update, @PathVariable("id") Long id) {
		Optional<Usuario> u = usuarioService.updateEntity(update, id);
		return ResponseEntity.of(u);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		Boolean b = usuarioService.deleteEntity(id);
		if (!b) {
			return new ResponseEntity<Boolean>(b, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(b);
	}
}
