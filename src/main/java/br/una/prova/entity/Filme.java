package br.una.prova.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
	@NotBlank(message = "Campo obrigatório")
    private String nome;

	private int ano;
	
	@NotBlank(message = "Campo obrigatório")
	private String diretor;
	
	@Min(value=0)
	@Max(value=10)
	private int imdb;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getImdb() {
		return imdb;
	}

	public void setImdb(int imdb) {
		this.imdb = imdb;
	}
}
