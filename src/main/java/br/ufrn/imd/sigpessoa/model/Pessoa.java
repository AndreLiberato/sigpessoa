package br.ufrn.imd.sigpessoa.model;

import java.util.Date;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 32)
	private String nome;

	@Column(nullable = false, length = 64)
	private String sobrenome;

	@Column(nullable = false)
	private Date dataNascimento;

	Pessoa() {}
	
	public Pessoa(String nome, String sobrenome, Date dataNascimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void fill(Pessoa p) {
		this.nome = p.nome;
		this.sobrenome = p.sobrenome;
		this.dataNascimento = p.dataNascimento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Pessoa)) {
			return false;
		}
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(this.id, pessoa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public String toString() {
		return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento.toString() + '}';
	}
}
