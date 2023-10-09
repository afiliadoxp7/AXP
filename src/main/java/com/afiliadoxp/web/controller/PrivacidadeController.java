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

import com.afiliadoxp.domain.Privacidade;
import com.afiliadoxp.repository.PrivacidadeRepository;

@Controller
public class PrivacidadeController {
	
	@Autowired
	private PrivacidadeRepository privacidadeRepository;

	@GetMapping("/listarPrivacidades")
	public String exibirLista(Model model) {
		model.addAttribute("lista", privacidadeRepository.findAll(Sort.by("nome")));
		return "privacidade/privacidade-list";
	}
	
	@GetMapping("/exibirFormPrivacidade")
	public String exibirForm(Privacidade privacidade) {
		return "privacidade/privacidade-form";
	}
	
	@PostMapping("/salvarPrivacidade")
	public String salvarPrivacidade(@Valid Privacidade privacidade, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(privacidade);
		}
		this.privacidadeRepository.save(privacidade);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarPrivacidades";
	}

	@GetMapping("/editarPrivacidade")
	public String editarPrivacidade(Long id, Model model) {
		model.addAttribute("privacidade", this.privacidadeRepository.findById(id));
		return "privacidade/privacidade-form";
	}
	
	@GetMapping("/removerPrivacidade")
	public String removerPrivacidade(Long id, ModelMap model) {
		this.privacidadeRepository.deleteById(id);
		return "redirect:/listarPrivacidades";
	}

}
