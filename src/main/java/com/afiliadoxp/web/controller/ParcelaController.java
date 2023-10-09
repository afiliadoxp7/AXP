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

import com.afiliadoxp.domain.Parcela;
import com.afiliadoxp.repository.ParcelaRepository;

@Controller
public class ParcelaController {
	
	@Autowired
	private ParcelaRepository parcelaRepository;

	@GetMapping("/listarParcelas")
	public String exibirLista(Model model) {
		model.addAttribute("lista", parcelaRepository.findAll(Sort.by("nome")));
		return "parcela/parcela-list";
	}
	
	@GetMapping("/exibirFormParcela")
	public String exibirForm(Parcela parcela) {
		return "parcela/parcela-form";
	}
	
	@PostMapping("/salvarParcela")
	public String salvarParcela(@Valid Parcela parcela, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(parcela);
		}
		this.parcelaRepository.save(parcela);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarParcelas";
	}

	@GetMapping("/editarParcela")
	public String editarParcela(Long id, Model model) {
		model.addAttribute("parcela", this.parcelaRepository.findById(id));
		return "parcela/parcela-form";
	}
	
	@GetMapping("/removerParcela")
	public String removerParcela(Long id, ModelMap model) {
		this.parcelaRepository.deleteById(id);
		return "redirect:/listarParcelas";
	}

}
