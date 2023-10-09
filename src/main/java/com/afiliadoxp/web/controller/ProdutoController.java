package com.afiliadoxp.web.controller;

import java.io.IOException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.afiliadoxp.domain.Produto;
import com.afiliadoxp.repository.CategoriaRepository;
import com.afiliadoxp.repository.FornecedorRepository;
import com.afiliadoxp.repository.GeneroRepository;
import com.afiliadoxp.repository.ParcelaRepository;
import com.afiliadoxp.repository.ProdutoRepository;
import com.afiliadoxp.repository.ValorRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private ValorRepository valorRepository;
	@Autowired
	private ParcelaRepository parcelaRepository;
	
	
	@GetMapping("/listarProdutos")
	public String exibirLista(Model model) {
		model.addAttribute("lista", produtoRepository.findAll(Sort.by("nome")));
		return "produto/produto-list";
	}
	
	@GetMapping("/listarProdutosFornecedores")
	public String exibirprodutoFornecedorLista(Model model) {
		model.addAttribute("lista", produtoRepository.findAll(Sort.by("nome")));
		return "produto/produtoFornecedor-list";
	}
	
	@GetMapping("/listarProdutosValores")
	public String exibirprodutoValorLista(Model model) {
		model.addAttribute("lista", produtoRepository.findAll(Sort.by("nome")));
		return "produto/produtoValor-list";
	}
	
	@GetMapping("/exibirFormProduto")
	public String exibirForm(Produto produto, Model model) {
		model.addAttribute("listaParcelas", this.parcelaRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaPorcentos", this.valorRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaCategorias", this.categoriaRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaGeneros", this.generoRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaFornecedores", this.fornecedorRepository.findAll(Sort.by("nome")));
		
		
		return "produto/produto-form";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@Valid Produto produto, 			
			BindingResult result, Model model, 
			@RequestParam("fileProduto") MultipartFile file) {
		
		if (result.hasErrors()) {
			return exibirForm(produto, model);
		}
		try {
			produto.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.produtoRepository.save(produto);
		return "redirect:/listarProdutos";
	}

	@GetMapping("/editarProduto")
	public String editarProduto(Long id, Model model) {
		model.addAttribute("produto", this.produtoRepository.findById(id));
		
		model.addAttribute("listaCategorias", this.categoriaRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaGeneros", this.generoRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaFornecedores", this.fornecedorRepository.findAll(Sort.by("nome")));
		
		model.addAttribute("listaParcelas", this.parcelaRepository.findAll(Sort.by("nome")));
		model.addAttribute("listaPorcentos", this.valorRepository.findAll(Sort.by("nome")));
		return "produto/produto-form";
	}

	@GetMapping("/removerProduto")
	public String removerProduto(Long id) {
		this.produtoRepository.deleteById(id);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/imagem/{idprod}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idprod") Long idprod) {
		@SuppressWarnings("deprecation")
		Produto produto = this.produtoRepository.getOne(idprod);
		return produto.getImagem();
	}


}
