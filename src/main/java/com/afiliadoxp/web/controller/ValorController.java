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

import com.afiliadoxp.domain.Valor;
import com.afiliadoxp.repository.ValorRepository;

@Controller
public class ValorController {
	
	@Autowired
	private ValorRepository valorRepository;

	@GetMapping("/listarValores")
	public String exibirLista(Model model) {
		model.addAttribute("lista", valorRepository.findAll(Sort.by("nome")));
		return "valor/valor-list";
	}
	
	@GetMapping("/exibirFormValor")
	public String exibirForm(Valor valor) {
		return "valor/valor-form";
	}
	
	@PostMapping("/salvarValor")
	public String salvarValor(@Valid Valor valor, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(valor);
		}
		this.valorRepository.save(valor);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarValores";
	}

	@GetMapping("/editarValor")
	public String editarValor(Long id, Model model) {
		model.addAttribute("valor", this.valorRepository.findById(id));
		return "valor/valor-form";
	}
	
	@GetMapping("/removerValor")
	public String removerValor(Long id, ModelMap model) {
		this.valorRepository.deleteById(id);
		return "redirect:/listarValores";
	}

}
