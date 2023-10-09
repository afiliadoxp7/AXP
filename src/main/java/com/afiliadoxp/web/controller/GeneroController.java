package com.afiliadoxp.web.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afiliadoxp.domain.Genero;
import com.afiliadoxp.repository.GeneroRepository;

@Controller
public class GeneroController {
	
	@Autowired
	private GeneroRepository generoRepository;

	@GetMapping("/listarGeneros")
	public String exibirLista(Model model) {
		model.addAttribute("lista", generoRepository.findAll(Sort.by("nome")));
		return "genero/genero-list";
	}
	
	@GetMapping("/exibirFormGenero")
	public String exibirForm(Genero genero) {
		return "genero/genero-form";
	}
	
	@PostMapping("/salvarGenero")
	public String salvarGenero(@Valid Genero genero, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(genero);
		}
		this.generoRepository.save(genero);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarGeneros";
	}

	@GetMapping("/editarGenero")
	public String editarGenero(Long id, Model model) {
		model.addAttribute("genero", this.generoRepository.findById(id));
		return "genero/genero-form";
	}
	
	@GetMapping("/removerGenero")
	public String removerGenero(Long id, ModelMap model) {
		this.generoRepository.deleteById(id);
		return "redirect:/listarGeneros";
	}

}
