package br.ufrn.imd.sigpessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufrn.imd.sigpessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
