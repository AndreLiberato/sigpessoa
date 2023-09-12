package br.ufrn.imd.sigpessoa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.ufrn.imd.sigpessoa.model.Papel;
import br.ufrn.imd.sigpessoa.model.Pessoa;
import br.ufrn.imd.sigpessoa.model.Usuario;
import br.ufrn.imd.sigpessoa.service.PapelService;
import br.ufrn.imd.sigpessoa.service.PessoaService;
import br.ufrn.imd.sigpessoa.service.UsuarioService;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(PapelService PapelService, PessoaService pessoaService,
			UsuarioService usuarioService) {
		return args -> {
			
			Pessoa pessoa = pessoaService.createEntity(new Pessoa("Pessoa 1", "Da silva", new Date()));
			log.info("Preloading " + pessoa.toString());
			
			Papel papel1 = PapelService.createEntity(new Papel("Papel 1"));
			log.info("Preloading " + papel1.toString());

			Papel papel2 = PapelService.createEntity(new Papel("Papel 2"));
			log.info("Preloading " + papel2.toString());
			
			Set<Papel> papeis1 = new HashSet<Papel>();
			Set<Papel> papeis2 = new HashSet<Papel>();
			
			papeis1.add(papel1);
			papeis2.add(papel2);
			
			Usuario usuario1 = usuarioService.createEntity(new Usuario("Usuario 1", papeis1, pessoa));
			log.info("Preloading " + usuario1.toString());
			
			Usuario usuario2 = usuarioService.createEntity(new Usuario("Usuario 2", papeis2, pessoa));
			log.info("Preloading " + usuario2.toString());
		};
	}
}
