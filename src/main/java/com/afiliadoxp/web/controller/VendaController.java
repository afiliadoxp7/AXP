package com.afiliadoxp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.afiliadoxp.domain.Produto;
import com.afiliadoxp.repository.ProdutoRepository;

@Controller
public class VendaController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// ======LISTAR OFERTAS==========================================
	@GetMapping("/exibirProdutosVenda")
	public String exibirProdutos(Model model) {
		Sort sort = Sort.by(Sort.Direction.ASC, "nome");
		PageRequest page = PageRequest.of(0, 8, sort);// Quantidades de cards a mostrar na pagina
		model.addAttribute("listaProdutos", this.produtoRepository.findAll(page));
		return "vendas/produto-search";
	}

	@GetMapping("/exibirProdutosVenda/ajax")
	public String listarCards(@RequestParam(name = "page", defaultValue = "1") int page, 
								Model model) {
		Sort sort = Sort.by(Sort.Direction.ASC, "nome");
		PageRequest pageRequest = PageRequest.of(page, 1000, sort);// Quantidades de cards a mostrar na pagina
		
		model.addAttribute("listaProdutos", this.produtoRepository.findAll(pageRequest));
		
		
		return "vendas/list-card";
	}
	
	
	// ======LISTAR OFERTAS==========================================
	@GetMapping("/ProdutosVenda")
	public String Produtos(Model model) {
		Sort sort = Sort.by(Sort.Direction.ASC, "nome");
		PageRequest page = PageRequest.of(0, 1000, sort);// Quantidades de cards a mostrar na pagina
		model.addAttribute("listaProdutos", this.produtoRepository.findAll(page));
		return "vendas/produto-search";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// ===================== Pesquisar OFERTAS =================================
	@PostMapping("/pesquisarProdutos")
	public String pesquisarProdutos(String nomeProduto, Model model) {

		List<Produto> resultado = this.produtoRepository.findByNomeContainingIgnoreCase(nomeProduto, Sort.by("nome"));
		model.addAttribute("listaProdutos", resultado);
		return "vendas/produto-search";
	}

}
