package br.ufrn.imd.sigpessoa.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import br.ufrn.imd.sigpessoa.model.Pessoa;
import br.ufrn.imd.sigpessoa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Set<Usuario> findByPessoa(Pessoa pessoa);
}
