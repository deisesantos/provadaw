package br.una.prova.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.una.prova.entity.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Integer>{
	
	public List <Filme> findByNomeLike(String nome);
	
	public List <Filme> findByImdbGreaterThan(int imdb);
	
	//public List <Filme> findByNomeIgnoreCaseLikeAndImdbGreaterThan (String nome, int imdb);
}
