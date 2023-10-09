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

import com.afiliadoxp.domain.Fornecedor;
import com.afiliadoxp.repository.FornecedorRepository;

@Controller
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("/listarFornecedores")
	public String exibirLista(Model model) {
		model.addAttribute("lista", fornecedorRepository.findAll(Sort.by("nome")));
		return "fornecedor/fornecedor-list";
	}
	
	@GetMapping("/exibirFormFornecedor")
	public String exibirForm(Fornecedor fornecedor) {
		return "fornecedor/fornecedor-form";
	}
	
	@PostMapping("/salvarFornecedor")
	public String salvarFornecedor(@Valid Fornecedor fornecedor, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(fornecedor);
		}
		this.fornecedorRepository.save(fornecedor);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarFornecedores";
	}

	@GetMapping("/editarFornecedor")
	public String editarFornecedor(Long id, Model model) {
		model.addAttribute("fornecedor", this.fornecedorRepository.findById(id));
		return "fornecedor/fornecedor-form";
	}
	
	@GetMapping("/removerFornecedor")
	public String removerFornecedor(Long id, ModelMap model) {
		this.fornecedorRepository.deleteById(id);
		return "redirect:/listarFornecedores";
	}

}
