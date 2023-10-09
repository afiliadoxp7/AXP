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

import com.afiliadoxp.domain.Categoria;
import com.afiliadoxp.repository.CategoriaRepository;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("/listarCategorias")
	public String exibirLista(Model model) {
		model.addAttribute("lista", categoriaRepository.findAll(Sort.by("nome")));
		return "categoria/categoria-list";
	}
	
	@GetMapping("/exibirFormCategoria")
	public String exibirForm(Categoria categoria) {
		return "categoria/categoria-form";
	}
	
	@PostMapping("/salvarCategoria")
	public String salvarCategoria(@Valid Categoria categoria, 
			BindingResult br, RedirectAttributes attr ) {
		if (br.hasErrors()) {
			return exibirForm(categoria);
		}
		this.categoriaRepository.save(categoria);	
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/listarCategorias";
	}

	@GetMapping("/editarCategoria")
	public String editarCategoria(Long id, Model model) {
		model.addAttribute("categoria", this.categoriaRepository.findById(id));
		return "categoria/categoria-form";
	}
	
	@GetMapping("/removerCategoria")
	public String removerCategoria(Long id, ModelMap model) {
		this.categoriaRepository.deleteById(id);
		return "redirect:/listarCategorias";
	}

}
