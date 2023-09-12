package br.ufrn.imd.sigpessoa.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ufrn.imd.sigpessoa.model.Pessoa;
import br.ufrn.imd.sigpessoa.model.Usuario;
import br.ufrn.imd.sigpessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa createEntity(Pessoa newPessoa) {
		return pessoaRepository.save(newPessoa);
	}

	public Boolean deleteEntity(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			return false;
		}
		Set<Usuario> usuarios = usuarioService.findUsuariByPessoa(pessoa.get());
		for (Usuario usuario : usuarios) {
			usuario.setPessoa(null);
			usuarioService.updateEntity(usuario, usuario.getId());

		}
		pessoaRepository.delete(pessoa.get());
		return true;
	}

	public Optional<Pessoa> updateEntity(Pessoa update, Long id) {
		Optional<Pessoa> p = pessoaRepository.findById(id);
		if (p.isEmpty()) {
			return Optional.empty();
		}
		p.get().fill(update);
		pessoaRepository.save(p.get());
		return p;
	}

	public Optional<Pessoa> findOne(Long id) {
		return pessoaRepository.findById(id);
	}
}
