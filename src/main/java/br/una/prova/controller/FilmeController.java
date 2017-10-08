package br.una.prova.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.una.prova.entity.Filme;
import br.una.prova.repository.FilmeRepository;

@Controller
public class FilmeController {

	@Autowired
	private FilmeRepository filmeRepository;

	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("filme", new Filme());
		model.addAttribute("filmes", filmeRepository.findAll());
		model.addAttribute("data", getAno());
		return "filme/listar";
	}

	@GetMapping("/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		model.addAttribute("filme", filmeRepository.findOne(id));
		model.addAttribute("filmes", filmeRepository.findAll());
		return "filme/formulario";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("filme", new Filme());
		return "filme/formulario";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Filme filme, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "filme/formulario";
		}
		
		filmeRepository.save(filme);
		return "redirect:/";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Integer id) {
		filmeRepository.delete(id);
		return "redirect:/";
	}

	/*@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String nome) {
		if("".equals(nome) || nome == null){
			return list(model);
		}
		
		model.addAttribute("filmes", filmeRepository.findByNomeIgnoreCaseLikeAndImdbGreaterThan("%" + nome + "%", 6));
		model.addAttribute("data", getAno());
		return "filme/listar";
	}*/
	
	@GetMapping("/buscar")
	public String buscarImdb(Model model){
		model.addAttribute("filme", new Filme());
		model.addAttribute("filmes", filmeRepository.findByImdbGreaterThan(5));
		model.addAttribute("data", getAno());
		return "filme/listar";
	}
	
	private String getAno(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
}